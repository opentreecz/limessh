package cz.opentree.limessh.plugin

import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.*
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.plugin.builtin.AuditAction
import kotlinx.coroutines.*
import java.security.SecureRandom
import java.util.Base64
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Semaphore

/** v2 Messenger API. Attaches only to sessions the user has already opened. */
class PluginSessionService : Service() {
    private data class Grant(val uid: Int, val sessionId: UUID)
    private val grants = ConcurrentHashMap<String, Grant>()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val slots = Semaphore(4)
    private val app get() = application as LimeApp
    private val messenger = Messenger(Handler(Looper.getMainLooper()) { message ->
        val uid = message.sendingUid
        val reply = message.replyTo
        val request = message.arg1
        val operation = message.what
        val data = Bundle(message.data)
        if (reply != null) {
            if (!slots.tryAcquire()) respond(reply, operation, request, Bundle().apply { putString("error", "Plugin gateway busy") })
            else scope.launch {
                try {
                    require(uid >= 0)
                    requirePermission(uid, PluginContract.PERMISSION_OPEN_SESSIONS)
                    check(!app.settings.checkLock()) { "limessh is locked" }
                    val result = when (operation) {
                        PluginContract.SessionApi.ATTACH -> {
                            require(grants.values.count { it.uid == uid } < 16) { "Too many session handles" }
                            require(grants.size < 256) { "Session handle limit reached" }
                            val connectionId = UUID.fromString(data.getString("connectionId"))
                            val session = app.sessionManager.findSession(connectionId.toString()) ?: error("Open the session in limessh first")
                            val token = Base64.getUrlEncoder().withoutPadding().encodeToString(ByteArray(32).also { SecureRandom().nextBytes(it) })
                            grants[token] = Grant(uid, session.id)
                            reply.binder.linkToDeath({ grants.remove(token) }, 0)
                            app.auditLog.log("uid:$uid", AuditAction.PLUGIN_CONNECTED, session.connectionId)
                            Bundle().apply { putString("handle", token); putInt("apiVersion", 2) }
                        }
                        PluginContract.SessionApi.EXECUTE, PluginContract.SessionApi.WRITE,
                        PluginContract.SessionApi.RELEASE -> {
                            val token = data.getString("handle").orEmpty()
                            val grant = grants[token]?.takeIf { it.uid == uid } ?: error("Invalid session handle")
                            val session = app.sessionManager.getSession(grant.sessionId) ?: error("Session ended")
                            if (operation == PluginContract.SessionApi.RELEASE) {
                                grants.remove(token)
                                app.auditLog.log("uid:$uid", AuditAction.PLUGIN_DISCONNECTED, session.connectionId)
                                Bundle()
                            } else {
                                requirePermission(uid, PluginContract.PERMISSION_EXECUTE_COMMANDS)
                                val command = data.getString("command").orEmpty()
                                require(command.length in 1..65536)
                                app.auditLog.log("uid:$uid", AuditAction.COMMAND_EXECUTED, session.connectionId)
                                if (operation == PluginContract.SessionApi.WRITE) {
                                    app.sessionManager.writeToSession(session.id, command.toByteArray())
                                    Bundle()
                                } else {
                                    val value = app.sessionManager.execute(session.id, command)
                                    Bundle().apply {
                                        putString("stdout", value.stdout.take(32768)); putString("stderr", value.stderr.take(32768))
                                        putInt("exitCode", value.exitCode)
                                        putBoolean("truncated", value.stdout.length > 32768 || value.stderr.length > 32768)
                                    }
                                }
                            }
                        }
                        else -> error("Unsupported API operation")
                    }
                    result.putBoolean("ok", true)
                    respond(reply, operation, request, result)
                } catch (e: CancellationException) { throw e }
                catch (e: Exception) {
                    respond(reply, operation, request, Bundle().apply { putBoolean("ok", false); putString("error", e.message ?: "Plugin request failed") })
                } finally { slots.release() }
            }
        }
        true
    })

    private fun requirePermission(uid: Int, permission: String) {
        check(checkPermission(permission, -1, uid) == PackageManager.PERMISSION_GRANTED) { "Plugin permission denied" }
    }

    private fun respond(reply: Messenger, operation: Int, request: Int, data: Bundle) {
        runCatching { reply.send(Message.obtain(null, operation).apply { arg1 = request; this.data = data }) }
    }

    override fun onBind(intent: Intent?) = messenger.binder

    override fun onDestroy() { scope.cancel(); grants.clear(); super.onDestroy() }
}
