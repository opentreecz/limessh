package cz.opentree.limessh.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.crypto.CredentialStore
import cz.opentree.limessh.data.repository.ConnectionRepository
import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.domain.model.Identity
import cz.opentree.limessh.ssh.KeyImport
import cz.opentree.limessh.ssh.KeyImportResult
import cz.opentree.limessh.ssh.KeyInspection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CancellationException
import java.util.UUID

data class IdentityEditState(
    val nickname: String = "",
    val username: String = "",
    val authMethod: AuthMethod = AuthMethod.PASSWORD,
    val password: String = "",
    val privateKeyPem: String = "",
    val keyPassphrase: String = "",
    val id: String = UUID.randomUUID().toString(),
    /** Parsed, non-secret details of the entered key, or null until it is checked. */
    val keyInfo: KeyInspection? = null,
    /** Guidance or an error about the entered key. */
    val keyMessage: String? = null,
    val keyChecking: Boolean = false,
)

class IdentityEditViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val repo = ConnectionRepository(db)
    private val credStore = CredentialStore(application)

    private val _state = MutableStateFlow(IdentityEditState())
    val state: StateFlow<IdentityEditState> = _state.asStateFlow()
    private val _saving = MutableStateFlow(false)
    val saving = _saving.asStateFlow()

    fun load(id: String) {
        viewModelScope.launch {
            val identity = repo.getIdentity(id) ?: return@launch
            val password = credStore.getPassword(id) ?: ""
            val privateKey = credStore.getPrivateKey(id) ?: ""
            val passphrase = credStore.getKeyPassphrase(id) ?: ""
            _state.value = IdentityEditState(
                id = id,
                nickname = identity.nickname,
                username = identity.username,
                authMethod = identity.authMethod,
                password = password,
                privateKeyPem = privateKey,
                keyPassphrase = passphrase,
            )
        }
    }

    fun updateNickname(v: String) { _state.value = _state.value.copy(nickname = v) }
    fun updateUsername(v: String) { _state.value = _state.value.copy(username = v) }
    fun updateAuthMethod(v: AuthMethod) { _state.value = _state.value.copy(authMethod = v) }
    fun updatePassword(v: String) { _state.value = _state.value.copy(password = v) }
    fun updatePrivateKey(v: String) {
        _state.value = _state.value.copy(privateKeyPem = v, keyInfo = null, keyMessage = null)
    }
    fun updateKeyPassphrase(v: String) {
        _state.value = _state.value.copy(keyPassphrase = v, keyInfo = null, keyMessage = null)
    }

    /** Applies key text from a picked file or the clipboard, then validates it. */
    fun importKeyText(text: String) {
        _state.value = _state.value.copy(privateKeyPem = KeyImport.normalize(text), keyInfo = null, keyMessage = null)
        checkKey()
    }

    fun reportKeyImportProblem(message: String) {
        _state.value = _state.value.copy(keyInfo = null, keyMessage = message)
    }

    /** Validates the entered key with the login parser. Passphrases and key text are never logged. */
    fun checkKey() {
        val snapshot = _state.value
        if (snapshot.privateKeyPem.isBlank()) {
            _state.value = snapshot.copy(keyMessage = "Import or paste a private key first.")
            return
        }
        _state.value = snapshot.copy(keyChecking = true)
        viewModelScope.launch {
            val result = withContext(Dispatchers.Default) { KeyImport.inspect(snapshot.privateKeyPem, snapshot.keyPassphrase.ifEmpty { null }) }
            val current = _state.value
            // Ignore a stale result if the user edited the key or passphrase meanwhile.
            if (current.privateKeyPem != snapshot.privateKeyPem || current.keyPassphrase != snapshot.keyPassphrase) {
                _state.value = current.copy(keyChecking = false)
                return@launch
            }
            _state.value = when (result) {
                is KeyImportResult.Valid -> current.copy(
                    privateKeyPem = result.normalizedPem, keyInfo = result.inspection, keyChecking = false,
                    keyMessage = "Key is valid: ${result.inspection.keyType}${if (result.inspection.encrypted) ", passphrase accepted" else ""}.",
                )
                is KeyImportResult.NeedsPassphrase -> current.copy(
                    privateKeyPem = result.normalizedPem, keyInfo = null, keyChecking = false,
                    keyMessage = "This ${result.format} key is encrypted. Enter its passphrase, then check the key.",
                )
                is KeyImportResult.Invalid -> current.copy(keyInfo = null, keyChecking = false, keyMessage = result.message)
            }
        }
    }

    fun save(onSaved: () -> Unit, onError: (String) -> Unit) {
        if (_saving.value) return
        _saving.value = true
        viewModelScope.launch {
            try {
            val s = _state.value
            val identity = Identity(
                id = UUID.fromString(s.id),
                nickname = s.nickname,
                username = s.username.trim(),
                authMethod = s.authMethod,
            )
            withContext(Dispatchers.IO) {
            when (s.authMethod) {
                AuthMethod.PASSWORD, AuthMethod.KEYBOARD_INTERACTIVE -> {
                    credStore.storePassword(s.id, s.password)
                }
                AuthMethod.PUBLIC_KEY -> {
                    require(s.privateKeyPem.isNotBlank()) { "Enter a private key" }
                    // Never persist a key that login would later reject.
                    val verified = when (val result = KeyImport.inspect(s.privateKeyPem, s.keyPassphrase.ifEmpty { null })) {
                        is KeyImportResult.Valid -> result
                        is KeyImportResult.NeedsPassphrase -> error("This key is encrypted. Enter its passphrase before saving.")
                        is KeyImportResult.Invalid -> error(result.message)
                    }
                    credStore.storePrivateKey(s.id, verified.normalizedPem)
                    credStore.storeKeyPassphrase(s.id, s.keyPassphrase)
                }
            }
            repo.upsertIdentity(identity)
            }
            onSaved()
            } catch (e: CancellationException) { throw e }
            catch (e: Exception) { onError(e.message ?: "Could not save identity") }
            finally { _saving.value = false }
        }
    }
}
