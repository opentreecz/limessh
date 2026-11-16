package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.ConnectionGroup
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupListScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val repository = remember { ConnectionRepository(AppDatabase.getInstance(context)) }
    val groups by repository.observeGroups().collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    var name by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    Scaffold(topBar = { TopAppBar(title = { Text("Connection groups") }, navigationIcon = {
        IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
    }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("Assign connections to groups in the connection editor.")
            OutlinedTextField(name, { name = it }, label = { Text("Group name") })
            Button(enabled = name.isNotBlank(), onClick = { scope.launch {
                try { repository.saveGroup(ConnectionGroup(name = name.trim())); name = "" }
                catch (e: Exception) { error = e.message }
            } }) { Text("Create group") }
            error?.let { Text(it) }
            LazyColumn {
                items(groups, key = { it.id }) { group ->
                    ListItem(headlineContent = { Text(group.name) }, trailingContent = {
                        TextButton(onClick = { scope.launch { repository.deleteGroup(group) } }) { Text("Delete") }
                    })
                }
            }
        }
    }
}
