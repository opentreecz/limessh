package cz.opentree.limessh.plugin.automation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.ui.screens.InactivityLockScreen
import cz.opentree.limessh.ui.theme.LimeSshTheme
import java.util.UUID

class TaskerConfigActivity : FragmentActivity() {
    override fun onUserInteraction() {
        super.onUserInteraction()
        (application as LimeApp).settings.onUserActivity()
    }

    override fun onResume() {
        super.onResume()
        (application as LimeApp).settings.checkLock()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResult(Activity.RESULT_CANCELED)
        val app = application as LimeApp
        val repository = ConnectionRepository(AppDatabase.getInstance(app))
        setContent {
            val locked by app.settings.locked.collectAsState()
            LimeSshTheme {
                Surface {
                    if (locked || app.settings.checkLock()) InactivityLockScreen { app.settings.unlock() }
                    else {
                        val connections by repository.observeConnections().collectAsState(initial = emptyList())
                        val snippets by repository.observeSnippets().collectAsState(initial = emptyList())
                        var connectionId by remember { mutableStateOf<UUID?>(null) }
                        var snippetId by remember { mutableStateOf<UUID?>(null) }
                        var error by remember { mutableStateOf<String?>(null) }
                        Column(Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState())) {
                            Text("limessh · Tasker action", style = MaterialTheme.typography.headlineSmall)
                            Text("Authorize this saved command for this connection. The session must already be open and limessh unlocked. Editing the saved command changes what this action runs.")
                            Text("Connection")
                            connections.forEach { connection -> FilterChip(selected = connectionId == connection.id,
                                onClick = { connectionId = connection.id }, label = { Text(connection.nickname.ifBlank { connection.address }) }) }
                            Text("Saved command")
                            snippets.forEach { snippet -> FilterChip(selected = snippetId == snippet.id,
                                onClick = { snippetId = snippet.id }, label = { Text(snippet.name) }) }
                            Button(enabled = connectionId != null && snippetId != null, onClick = {
                                try {
                                    val token = AutomationGrants(app).create(connectionId!!, snippetId!!)
                                    val bundle = Bundle().apply { putString(AutomationGrants.TOKEN, token) }
                                    val result = Intent().putExtra(AutomationGrants.EXTRA_BUNDLE, bundle)
                                        .putExtra(AutomationGrants.EXTRA_BLURB, "Run ${snippets.first { it.id == snippetId }.name} in limessh")
                                    setResult(Activity.RESULT_OK, result)
                                    finish()
                                } catch (e: Exception) { error = e.message }
                            }) { Text("Authorize and save") }
                            TextButton(onClick = { finish() }) { Text("Cancel") }
                            TextButton(onClick = { AutomationGrants(app).revokeAll(); error = "All automation grants revoked" }) { Text("Revoke all automation grants") }
                            error?.let { Text(it) }
                        }
                    }
                }
            }
        }
    }
}
