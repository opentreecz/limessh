package cz.opentree.limessh.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.opentree.limessh.ui.screens.*

object Routes {
    const val CONNECTIONS = "connections"
    const val CONNECTION_EDIT = "connection/edit?id={id}"
    const val CONNECTION_NEW = "connection/new"
    const val TERMINAL = "terminal/{connectionId}"
    const val SNIPPETS = "snippets"
    const val PORT_FORWARDS = "portforwards"
    const val SETTINGS = "settings"

    fun terminal(connectionId: String) = "terminal/$connectionId"
    fun editConnection(id: String) = "connection/edit?id=$id"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.CONNECTIONS) {
        composable(Routes.CONNECTIONS) {
            ConnectionListScreen(
                onConnect = { connectionId ->
                    navController.navigate(Routes.terminal(connectionId))
                },
            )
        }
        composable(Routes.TERMINAL) { backStackEntry ->
            val connectionId = backStackEntry.arguments?.getString("connectionId") ?: return@composable
            TerminalScreen(
                connectionId = connectionId,
                onBack = { navController.popBackStack() },
            )
        }
    }
}
