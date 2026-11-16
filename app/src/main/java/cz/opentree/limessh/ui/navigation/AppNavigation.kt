package cz.opentree.limessh.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.opentree.limessh.ui.MainActivity
import cz.opentree.limessh.ui.SshQuickConnect
import cz.opentree.limessh.ui.screens.*

object Routes {
    const val CONNECTIONS = "connections"
    const val CONNECTION_EDIT = "connection/edit?id={id}"
    const val CONNECTION_NEW = "connection/new"
    const val TERMINAL = "terminal/{connectionId}"
    const val SNIPPETS = "snippets"
    const val PORT_FORWARDS = "portforwards"
    const val SETTINGS = "settings"
    const val IDENTITIES = "identities"
    const val IDENTITY_EDIT = "identity/edit?id={id}"
    const val IDENTITY_NEW = "identity/new"
    const val SESSIONS = "sessions"
    const val SFTP = "sftp/{sessionId}"
    const val KEY_GENERATOR = "keygen"
    const val EXTENSIONS = "extensions?sessionId={sessionId}"
    const val GROUPS = "groups"
    const val KNOWN_HOSTS = "known_hosts"

    fun terminal(connectionId: String) = "terminal/$connectionId"
    fun editConnection(id: String) = "connection/edit?id=$id"
    fun editIdentity(id: String) = "identity/edit?id=$id"
    fun sftp(sessionId: String) = "sftp/$sessionId"
    fun extensions(sessionId: String? = null) = if (sessionId == null) "extensions" else "extensions?sessionId=$sessionId"
}

@Composable
fun AppNavigation(
    startConnectionId: String? = null,
    sshQuickConnect: SshQuickConnect? = null,
    onConnectionOpened: () -> Unit = {},
    onQuickConnectDismissed: () -> Unit = {},
) {
    val navController = rememberNavController()
    LaunchedEffect(startConnectionId) {
        if (startConnectionId != null) {
            navController.navigate(Routes.terminal(startConnectionId)) { launchSingleTop = true }
            onConnectionOpened()
        }
    }

    // Quick-connect dialog for inbound ssh:// URIs.
    sshQuickConnect?.let { qc ->
        AlertDialog(
            onDismissRequest = { onQuickConnectDismissed() },
            title = { Text("Connect via ssh://") },
            text = {
                Text(
                    "Host: ${qc.address}:${qc.port}" +
                        (if (qc.user != null) "\nUser: ${qc.user}" else "") +
                        "\n\nOpen the connection editor to save and connect."
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    onQuickConnectDismissed()
                    navController.navigate(Routes.connectionNew(qc.address, qc.port, qc.user))
                }) { Text("Edit & connect") }
            },
            dismissButton = {
                TextButton(onClick = { onQuickConnectDismissed() }) { Text("Cancel") }
            },
        )
    }

    NavHost(navController = navController, startDestination = Routes.CONNECTIONS) {

        composable(Routes.CONNECTIONS) {
            ConnectionListScreen(
                onConnect = { connectionId ->
                    navController.navigate(Routes.terminal(connectionId))
                },
                onNewConnection = { navController.navigate(Routes.CONNECTION_NEW) },
                onEditConnection = { id -> navController.navigate(Routes.editConnection(id)) },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
                onOpenIdentities = { navController.navigate(Routes.IDENTITIES) },
                onOpenSessions = { navController.navigate(Routes.SESSIONS) },
                onOpenExtensions = { navController.navigate(Routes.extensions()) },
                onOpenSnippets = { navController.navigate(Routes.SNIPPETS) },
                onOpenForwards = { navController.navigate(Routes.PORT_FORWARDS) },
                onOpenGroups = { navController.navigate(Routes.GROUPS) },
            )
        }

        // New connection — optional pre-fill from ssh:// URI query params.
        composable(
            route = "connection/new?address={address}&port={port}&user={user}",
            arguments = listOf(
                navArgument("address") { type = NavType.StringType; defaultValue = "" },
                navArgument("port") { type = NavType.StringType; defaultValue = "22" },
                navArgument("user") { type = NavType.StringType; nullable = true; defaultValue = null },
            ),
        ) { backStackEntry ->
            val prefillAddress = backStackEntry.arguments?.getString("address").orEmpty()
            val prefillPort = backStackEntry.arguments?.getString("port")?.toIntOrNull() ?: 22
            val prefillUser = backStackEntry.arguments?.getString("user")
            ConnectionEditorRoute(
                connectionId = null,
                prefillAddress = prefillAddress,
                prefillPort = if (prefillAddress.isNotBlank()) prefillPort else null,
                prefillUser = prefillUser,
                onBack = { navController.popBackStack() },
                onEditIdentity = { navController.navigate(Routes.editIdentity(it)) },
            )
        }

        composable(
            route = Routes.CONNECTION_EDIT,
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            ConnectionEditorRoute(
                connectionId = id,
                onBack = { navController.popBackStack() },
                onEditIdentity = { navController.navigate(Routes.editIdentity(it)) },
            )
        }

        composable(
            route = Routes.TERMINAL,
            arguments = listOf(navArgument("connectionId") { type = NavType.StringType }),
        ) { backStackEntry ->
            val connectionId = backStackEntry.arguments?.getString("connectionId") ?: return@composable
            TerminalScreen(
                connectionId = connectionId,
                onBack = { navController.popBackStack() },
                onOpenSftp = { sessionId -> navController.navigate(Routes.sftp(sessionId)) },
                onOpenExtensions = { sessionId -> navController.navigate(Routes.extensions(sessionId)) },
                onEditConnection = { navController.navigate(Routes.editConnection(connectionId)) },
            )
        }

        composable(Routes.SNIPPETS) {
            SnippetLibraryRoute(onBack = { navController.popBackStack() })
        }

        composable(Routes.PORT_FORWARDS) {
            PortForwardRoute(onBack = { navController.popBackStack() })
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(
                onBack = { navController.popBackStack() },
                onOpenKnownHosts = { navController.navigate(Routes.KNOWN_HOSTS) },
            )
        }

        composable(Routes.IDENTITIES) {
            IdentityListScreen(
                onNewIdentity = { navController.navigate(Routes.IDENTITY_NEW) },
                onEditIdentity = { id -> navController.navigate(Routes.editIdentity(id)) },
                onOpenKeyGenerator = { navController.navigate(Routes.KEY_GENERATOR) },
                onBack = { navController.popBackStack() },
            )
        }

        composable(Routes.IDENTITY_NEW) {
            IdentityEditScreen(
                identityId = null,
                onSaved = { navController.popBackStack() },
                onBack = { navController.popBackStack() },
            )
        }

        composable(
            route = Routes.IDENTITY_EDIT,
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            IdentityEditScreen(
                identityId = id,
                onSaved = { navController.popBackStack() },
                onBack = { navController.popBackStack() },
            )
        }

        composable(Routes.SESSIONS) {
            SessionListScreen(
                onOpenTerminal = { connectionId -> navController.navigate(Routes.terminal(connectionId)) },
                onBack = { navController.popBackStack() },
            )
        }

        composable(
            route = Routes.SFTP,
            arguments = listOf(navArgument("sessionId") { type = NavType.StringType }),
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getString("sessionId") ?: return@composable
            SftpBrowserScreen(
                sessionId = sessionId,
                onBack = { navController.popBackStack() },
            )
        }

        composable(Routes.KEY_GENERATOR) {
            KeyGeneratorScreen(onBack = { navController.popBackStack() })
        }

        composable(Routes.GROUPS) {
            GroupListScreen(onBack = { navController.popBackStack() })
        }

        composable(Routes.EXTENSIONS, arguments = listOf(navArgument("sessionId") {
            type = NavType.StringType; nullable = true; defaultValue = null
        })) { entry ->
            ExtensionsScreen(entry.arguments?.getString("sessionId"), onBack = { navController.popBackStack() })
        }

        composable(Routes.KNOWN_HOSTS) {
            KnownHostsScreen(onBack = { navController.popBackStack() })
        }
    }
}

private fun Routes.connectionNew(address: String, port: Int, user: String?): String {
    val base = "connection/new?address=${android.net.Uri.encode(address)}&port=$port"
    return if (user != null) "$base&user=${android.net.Uri.encode(user)}" else "$base"
}
