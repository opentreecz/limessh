package cz.opentree.limessh.ui.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cz.opentree.limessh.data.backup.BackupManager
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.migration.LimesshMetadataImporter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val app get() = getApplication<Application>()
    private val db by lazy { AppDatabase.getInstance(app) }
    private val backupManager by lazy { BackupManager(db) }
    private val metadataImporter by lazy { LimesshMetadataImporter(app, db) }

    /** Temporary URI held between the file picker and the password dialog. */
    var pendingRestoreUri: Uri? = null

    fun exportBackup(uri: Uri, password: String, onResult: (String) -> Unit) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                runCatching {
                    app.contentResolver.openOutputStream(uri)?.use { stream ->
                        backupManager.export(stream, password)
                        "Backup exported successfully."
                    } ?: "Could not open output file."
                }.getOrElse { e -> "Export failed: ${e.message}" }
            }
            onResult(result)
        }
    }

    fun restoreBackup(uri: Uri, password: String, onResult: (String) -> Unit) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                runCatching {
                    app.contentResolver.openInputStream(uri)?.use { stream ->
                        val report = backupManager.import(stream, password)
                        if (!report.success) {
                            "Restore failed: ${report.error}"
                        } else {
                            buildString {
                                appendLine("Restore complete.")
                                appendLine("Connections: ${report.connections}")
                                appendLine("Identities: ${report.identities}")
                                appendLine("Snippets: ${report.snippets}")
                                appendLine("Port forwards: ${report.portForwards}")
                                appendLine("Groups: ${report.groups}")
                                appendLine("Known hosts: ${report.knownHosts}")
                            }
                        }
                    } ?: "Could not open backup file."
                }.getOrElse { e -> "Restore failed: ${e.message}" }
            }
            onResult(result)
        }
    }

    fun importMetadata(uri: Uri, onResult: (String) -> Unit) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                runCatching {
                    app.contentResolver.openInputStream(uri)?.use { stream ->
                        val report = metadataImporter.importFromJson(stream)
                        if (!report.success) {
                            "Import failed: ${report.error}"
                        } else {
                            buildString {
                                appendLine("Metadata import complete.")
                                appendLine("Connections: ${report.connections}")
                                appendLine("Identities: ${report.identities}")
                                appendLine("Groups: ${report.groups}")
                                appendLine("Snippets: ${report.snippets}")
                                appendLine("Port forwards: ${report.portForwards}")
                                appendLine("Skipped: ${report.skipped}")
                                if (report.warnings.isNotEmpty()) {
                                    appendLine("Warnings:")
                                    report.warnings.forEach { appendLine("  - $it") }
                                }
                            }
                        }
                    } ?: "Could not open file."
                }.getOrElse { e -> "Import failed: ${e.message}" }
            }
            onResult(result)
        }
    }
}
