package cz.opentree.limessh.data.local.crypto

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

/**
 * Stores sensitive credentials (passwords, private keys) using Android's
 * EncryptedSharedPreferences backed by the Android Keystore.
 *
 * This replaces the legacy JuiceSSH AES-256-CBC/PBKDF2 scheme with
 * platform-backed encryption. Credentials are device-bound and not
 * portable without explicit export.
 */
class CredentialStore(context: Context) {

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    private val prefs = EncryptedSharedPreferences.create(
        "limessh_credentials",
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
    )

    fun storePassword(identityId: String, password: String) {
        prefs.edit().putString("pwd_$identityId", password).apply()
    }

    fun getPassword(identityId: String): String? =
        prefs.getString("pwd_$identityId", null)

    fun storePrivateKey(identityId: String, keyPem: String) {
        prefs.edit().putString("key_$identityId", keyPem).apply()
    }

    fun getPrivateKey(identityId: String): String? =
        prefs.getString("key_$identityId", null)

    fun storeKeyPassphrase(identityId: String, passphrase: String) {
        prefs.edit().putString("keypass_$identityId", passphrase).apply()
    }

    fun getKeyPassphrase(identityId: String): String? =
        prefs.getString("keypass_$identityId", null)

    fun deleteCredentials(identityId: String) {
        prefs.edit()
            .remove("pwd_$identityId")
            .remove("key_$identityId")
            .remove("keypass_$identityId")
            .apply()
    }

    fun hasPassword(identityId: String): Boolean = prefs.contains("pwd_$identityId")
    fun hasPrivateKey(identityId: String): Boolean = prefs.contains("key_$identityId")
}
