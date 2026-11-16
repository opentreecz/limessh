package cz.opentree.limessh.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.IdentityEntity
import cz.opentree.limessh.data.repository.ConnectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import cz.opentree.limessh.data.local.crypto.CredentialStore

class IdentityListViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    private val repo = ConnectionRepository(db)

    val identities: Flow<List<IdentityEntity>> = db.identityDao().observeAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun deleteIdentity(id: String) {
        viewModelScope.launch {
            repo.deleteIdentity(id)
            // Remove the identity's saved password, private key and key passphrase too.
            withContext(Dispatchers.IO) { CredentialStore(getApplication()).deleteCredentials(id) }
        }
    }
}
