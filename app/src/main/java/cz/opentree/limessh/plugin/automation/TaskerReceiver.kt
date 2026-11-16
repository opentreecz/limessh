package cz.opentree.limessh.plugin.automation

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.plugin.builtin.AuditAction
import kotlinx.coroutines.*
import androidx.work.*

/** Locale/Tasker action: run a configured saved command on an already-open session. */
class TaskerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != "com.twofortyfouram.locale.intent.action.FIRE_SETTING") return
        val token = intent.getBundleExtra(AutomationGrants.EXTRA_BUNDLE)?.getString(AutomationGrants.TOKEN) ?: return
        val app = context.applicationContext as LimeApp
        val result = goAsync()
        CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
            try {
                check(!app.settings.checkLock()) { "limessh is locked" }
                check(AutomationGrants(app).resolve(token) != null) { "Revoked automation grant" }
                // Return promptly; remote execution must not exceed a BroadcastReceiver deadline.
                val request = OneTimeWorkRequestBuilder<AutomationWorker>()
                    .setInputData(workDataOf("grantDigest" to AutomationGrants.digest(token))).build()
                WorkManager.getInstance(app).enqueueUniqueWork(
                    "automation-${AutomationGrants.digest(token)}", ExistingWorkPolicy.KEEP, request,
                ).result.get()
                if (isOrderedBroadcast) result.resultCode = Activity.RESULT_OK // Accepted, not remote exit status.
            } catch (e: Exception) {
                // Do not log tokens, command text, credentials or remote output.
                app.auditLog.log("Tasker", AuditAction.AUTOMATION_FAILED)
                if (isOrderedBroadcast) result.resultCode = Activity.RESULT_CANCELED
            } finally { result.finish() }
        }
    }
}

class AutomationWorker(context: Context, parameters: WorkerParameters) : CoroutineWorker(context, parameters) {
    override suspend fun doWork(): Result {
        val app = applicationContext as LimeApp
        return try {
            check(!app.settings.checkLock()) { "limessh is locked" }
            val (connectionId, snippetId) = AutomationGrants(app).resolveDigest(inputData.getString("grantDigest").orEmpty())
                ?: error("Revoked automation grant")
            val snippet = ConnectionRepository(AppDatabase.getInstance(app)).getSnippet(snippetId) ?: error("Snippet was deleted")
            val session = app.sessionManager.findSession(connectionId.toString()) ?: error("Open the SSH session first")
            val commandResult = app.sessionManager.execute(session.id, snippet.content)
            check(commandResult.exitCode == 0)
            app.auditLog.log("Tasker", AuditAction.SNIPPET_RUN, connectionId)
            Result.success()
        } catch (e: CancellationException) { throw e }
        catch (e: Exception) {
            app.auditLog.log("Tasker", AuditAction.AUTOMATION_FAILED)
            Result.failure()
        }
    }
}
