package cz.opentree.limessh

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LimeApp : Application() {

    val auditLog by lazy { cz.opentree.limessh.plugin.builtin.AuditLog() }
    val sessionManager by lazy { cz.opentree.limessh.ssh.SessionManager(this, auditLog) }
    val settings by lazy { cz.opentree.limessh.data.local.AppSettings(this) }

    companion object {
        const val CHANNEL_SESSION = "limessh_session"
        /** Last crash log file written by the debug crash handler. */
        const val CRASH_LOG_FILENAME = "limessh_crash.txt"
    }

    override fun onCreate() {
        super.onCreate()
        installCrashLogger()
        createNotificationChannels()
    }

    /**
     * Debug crash logger: writes uncaught exceptions to getExternalFilesDir / limessh_crash.txt
     * so they are readable without ADB. Remove before production release.
     */
    private fun installCrashLogger() {
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                val dir = getExternalFilesDir(null) ?: filesDir
                val file = File(dir, CRASH_LOG_FILENAME)
                val ts = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())
                file.writeText(buildString {
                    appendLine("=== LimeSSH crash — $ts ===")
                    appendLine("Thread: ${thread.name}")
                    appendLine()
                    appendLine(throwable.stackTraceToString())
                    throwable.cause?.let {
                        appendLine("Caused by:")
                        appendLine(it.stackTraceToString())
                    }
                })
            } catch (_: Exception) { /* best-effort */ }
            defaultHandler?.uncaughtException(thread, throwable)
        }
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val sessionChannel = NotificationChannel(
                CHANNEL_SESSION,
                "Active SSH Sessions",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Shows active LimeSSH connections"
                setShowBadge(false)
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(sessionChannel)
        }
    }
}
