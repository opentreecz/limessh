package cz.opentree.limessh.ui.lock

import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import cz.opentree.limessh.data.local.UnlockMethod

/** The concrete Android mechanism used to release the app lock. */
sealed interface UnlockPath {
    val notice: String?

    /** System BiometricPrompt. [credentialButton] offers the screen-lock credential on Android 8-10. */
    data class Prompt(
        val authenticators: Int,
        val credentialButton: Boolean = false,
        override val notice: String? = null,
    ) : UnlockPath

    /** Android lock-screen confirmation (PIN/pattern/password). */
    data class Keyguard(override val notice: String? = null) : UnlockPath

    data class Unavailable(val reason: String) : UnlockPath {
        override val notice: String? get() = reason
    }
}

/**
 * Chooses a mechanism from the user's policy and the device state.
 *
 * Android 11+ can combine strong biometrics and device credential in one prompt.
 * Android 8-10 cannot (and credential-only prompts are unsupported before Android 11),
 * so the credential uses the lock-screen confirmation activity there.
 * Biometric-only never traps the user when biometrics are removed: it falls back to
 * the device credential with an explanation instead of leaving the app permanently locked.
 */
fun planUnlock(
    method: UnlockMethod,
    sdkInt: Int,
    strongBiometricAvailable: Boolean,
    deviceSecure: Boolean,
): UnlockPath {
    if (!deviceSecure && !strongBiometricAvailable) {
        return UnlockPath.Unavailable("Set an Android screen lock (PIN, pattern or password) to unlock limessh.")
    }
    fun credential(notice: String? = null): UnlockPath =
        if (sdkInt >= 30) UnlockPath.Prompt(DEVICE_CREDENTIAL, notice = notice) else UnlockPath.Keyguard(notice)

    return when (method) {
        UnlockMethod.DEVICE_CREDENTIAL -> credential()
        UnlockMethod.BIOMETRIC_ONLY ->
            if (strongBiometricAvailable) UnlockPath.Prompt(BIOMETRIC_STRONG)
            else credential("No fingerprint or face is enrolled, so the device credential is used.")
        UnlockMethod.BIOMETRIC_OR_CREDENTIAL ->
            when {
                !strongBiometricAvailable -> credential()
                sdkInt >= 30 -> UnlockPath.Prompt(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
                else -> UnlockPath.Prompt(BIOMETRIC_STRONG, credentialButton = true)
            }
    }
}
