package cz.opentree.limessh.ui

import android.os.Bundle
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cz.opentree.limessh.ui.navigation.AppNavigation
import cz.opentree.limessh.ui.theme.LimeSshTheme
import androidx.compose.runtime.*
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.ui.screens.InactivityLockScreen
import kotlinx.coroutines.delay

/** Parsed fields from an inbound ssh:// URI for quick-connect. */
data class SshQuickConnect(val address: String, val port: Int, val user: String?)

class MainActivity : FragmentActivity() {
    private val app get() = application as LimeApp
    private var requestedConnection by mutableStateOf<String?>(null)
    private var sshQuickConnect by mutableStateOf<SshQuickConnect?>(null)

    private fun readConnectionIntent(value: Intent?) {
        val data = value?.data
        val id = value?.getStringExtra("connection_id")
            ?: if (data?.scheme == "limessh" && data.host == "connection") data.lastPathSegment else null
        requestedConnection = runCatching { java.util.UUID.fromString(id).toString() }.getOrNull()

        // Parse ssh:// URIs for quick-connect when no saved connection was found.
        if (requestedConnection == null && data?.scheme == "ssh") {
            val host = data.host
            if (!host.isNullOrBlank()) {
                val port = data.port.takeIf { it > 0 } ?: 22
                val user = data.userInfo?.takeIf { it.isNotBlank() }
                sshQuickConnect = SshQuickConnect(host, port, user)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        readConnectionIntent(intent)
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        app.settings.onUserActivity()
    }

    override fun onResume() {
        super.onResume()
        app.settings.checkLock()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        readConnectionIntent(intent)
        // Request notification permission outside of Compose to avoid requestCode overflow
        // when many rememberLauncherForActivityResult are registered across the nav graph.
        if (android.os.Build.VERSION.SDK_INT >= 33 &&
            checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 1001)
        }
        setContent {
            val locked by app.settings.locked.collectAsState()
            LaunchedEffect(Unit) { while (true) { delay(1000); app.settings.checkLock() } }
            LimeSshTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    if (locked) InactivityLockScreen(onUnlocked = { app.settings.unlock() })
                    else AppNavigation(
                        startConnectionId = requestedConnection,
                        sshQuickConnect = sshQuickConnect,
                        onConnectionOpened = { requestedConnection = null },
                        onQuickConnectDismissed = { sshQuickConnect = null },
                    )
                }
            }
        }
    }
}
