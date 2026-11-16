package cz.opentree.limessh.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.ConnectionEntity
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.Connection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class ConnectionListViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    private val repository = ConnectionRepository(db)

    val connections: Flow<List<ConnectionEntity>> = db.connectionDao().observeAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList(),
        )

    fun deleteConnection(id: String) {
        viewModelScope.launch {
            repository.deleteConnection(id)
        }
    }

    fun duplicateConnection(connection: Connection) {
        viewModelScope.launch {
            val copy = connection.copy(
                id = UUID.randomUUID(),
                nickname = if (connection.nickname.isBlank()) ""
                else "${connection.nickname} (copy)",
            )
            repository.upsertConnection(copy)
        }
    }
}
