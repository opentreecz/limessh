package cz.opentree.limessh.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.ConnectionEntity
import kotlinx.coroutines.flow.Flow

class ConnectionListViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    val connections: Flow<List<ConnectionEntity>> = db.connectionDao().observeAll()
}
