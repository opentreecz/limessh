package cz.opentree.limessh.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.opentree.limessh.domain.model.Snippet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnippetListScreen(
    snippets: List<Snippet>,
    onAdd: () -> Unit,
    onEdit: (Snippet) -> Unit,
    onExecute: ((Snippet) -> Unit)? = null,
    onBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Snippets") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                ),
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd) {
                Icon(Icons.Default.Add, "Add snippet")
            }
        },
    ) { padding ->
        if (snippets.isEmpty()) {
            Box(
                Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center,
            ) {
                Text("> No snippets saved.", style = MaterialTheme.typography.bodyMedium)
            }
        } else {
            LazyColumn(Modifier.padding(padding)) {
                items(snippets, key = { it.id }) { snippet ->
                    ListItem(
                        headlineContent = { Text(snippet.name) },
                        supportingContent = {
                            Text(
                                snippet.content.take(80),
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = 2,
                            )
                        },
                        trailingContent = {
                            Row {
                                if (snippet.runOnConnect) {
                                    AssistChip(
                                        onClick = {},
                                        label = { Text("auto", style = MaterialTheme.typography.labelSmall) },
                                    )
                                }
                                if (onExecute != null) {
                                    TextButton(onClick = { onExecute(snippet) }) { Text("Run") }
                                }
                            }
                        },
                        modifier = Modifier.clickable { onEdit(snippet) },
                    )
                    HorizontalDivider()
                }
            }
        }
    }
}
