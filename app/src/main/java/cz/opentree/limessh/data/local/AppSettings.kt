package cz.opentree.limessh.data.local

import android.content.Context
import android.os.SystemClock
import cz.opentree.limessh.ui.theme.TerminalThemes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

/** How the app lock is released. Existing SSH transports are unaffected by locking. */
enum class UnlockMethod(val storageValue: String) {
    /** PIN, pattern or password from the Android lock screen. */
    DEVICE_CREDENTIAL("device_credential"),
    /** Fingerprint/face when enrolled, with the device credential as fallback. */
    BIOMETRIC_OR_CREDENTIAL("biometric_or_credential"),
    /** Strong biometric only; no credential fallback. */
    BIOMETRIC_ONLY("biometric_only");

    companion object {
        fun fromStorage(value: String?) = entries.firstOrNull { it.storageValue == value } ?: BIOMETRIC_OR_CREDENTIAL
    }
}

data class AppPreferences(
    val fontSize: Int,
    val scrollback: Int,
    val lockTimeoutSeconds: Int,
    val terminalThemeId: String = TerminalThemes.DEFAULT_ID,
    val unlockMethod: UnlockMethod = UnlockMethod.BIOMETRIC_OR_CREDENTIAL,
)

/** UI lock keeps existing transports alive, but blocks app/plugin/automation entry. */
class AppSettings(context: Context) {
    private val prefs = context.getSharedPreferences("limessh_settings", Context.MODE_PRIVATE)
    private val _preferences = MutableStateFlow(read())
    val preferences = _preferences.asStateFlow()
    private val _locked = MutableStateFlow(_preferences.value.lockTimeoutSeconds > 0)
    val locked = _locked.asStateFlow()
    private var lastActivity = SystemClock.elapsedRealtime()

    private fun read() = AppPreferences(
        fontSize = prefs.getInt("fontSize", 13),
        scrollback = prefs.getInt("scrollback", 10000),
        lockTimeoutSeconds = prefs.getInt("lockTimeout", 0),
        terminalThemeId = TerminalThemes.byId(prefs.getString("terminalTheme", null)).id,
        unlockMethod = UnlockMethod.fromStorage(prefs.getString("unlockMethod", null)),
    )

    fun setFontSize(value: Int) {
        require(value in 8..28)
        prefs.edit().putInt("fontSize", value).apply()
        _preferences.value = read()
    }

    fun setScrollback(value: Int) {
        require(value in 0..10000)
        prefs.edit().putInt("scrollback", value).apply()
        _preferences.value = read()
    }

    fun setTerminalTheme(id: String) {
        require(TerminalThemes.all.any { it.id == id }) { "Unknown terminal theme" }
        prefs.edit().putString("terminalTheme", id).apply()
        _preferences.value = read()
    }

    fun setUnlockMethod(method: UnlockMethod) {
        prefs.edit().putString("unlockMethod", method.storageValue).apply()
        _preferences.value = read()
    }

    fun setLockTimeout(seconds: Int) {
        require(seconds in setOf(0, 30, 60, 300, 900))
        prefs.edit().putInt("lockTimeout", seconds).apply()
        _preferences.value = read()
        lastActivity = SystemClock.elapsedRealtime()
    }

    @Synchronized
    fun onUserActivity() { if (!_locked.value) lastActivity = SystemClock.elapsedRealtime() }

    @Synchronized
    fun checkLock(): Boolean {
        val timeout = _preferences.value.lockTimeoutSeconds
        if (timeout > 0 && SystemClock.elapsedRealtime() - lastActivity >= timeout * 1000L) _locked.value = true
        return _locked.value
    }

    /** Locks immediately when an unlock timeout policy is enabled. */
    @Synchronized
    fun lockNow(): Boolean {
        if (_preferences.value.lockTimeoutSeconds <= 0) return false
        _locked.value = true
        return true
    }

    @Synchronized
    fun unlock() { lastActivity = SystemClock.elapsedRealtime(); _locked.value = false }
}
