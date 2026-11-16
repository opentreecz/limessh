package cz.opentree.limessh

import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import cz.opentree.limessh.data.local.UnlockMethod
import cz.opentree.limessh.ui.lock.UnlockPath
import cz.opentree.limessh.ui.lock.planUnlock
import org.junit.Assert.*
import org.junit.Test

class UnlockPlannerTest {
    @Test fun deviceWithoutAnyScreenLockCannotUnlockAndExplainsWhy() {
        UnlockMethod.entries.forEach { method ->
            listOf(26, 29, 30, 35).forEach { sdk ->
                val path = planUnlock(method, sdk, strongBiometricAvailable = false, deviceSecure = false)
                assertTrue("$method/$sdk", path is UnlockPath.Unavailable)
                assertTrue(path.notice!!.contains("screen lock"))
            }
        }
    }

    @Test fun credentialOnlyUsesPromptOnAndroid11AndKeyguardBefore() {
        assertEquals(UnlockPath.Prompt(DEVICE_CREDENTIAL), planUnlock(UnlockMethod.DEVICE_CREDENTIAL, 30, true, true))
        assertEquals(UnlockPath.Prompt(DEVICE_CREDENTIAL), planUnlock(UnlockMethod.DEVICE_CREDENTIAL, 35, false, true))
        assertEquals(UnlockPath.Keyguard(), planUnlock(UnlockMethod.DEVICE_CREDENTIAL, 29, true, true))
        assertEquals(UnlockPath.Keyguard(), planUnlock(UnlockMethod.DEVICE_CREDENTIAL, 26, false, true))
    }

    @Test fun biometricWithFallbackIsOnePromptOnAndroid11PlusAndTwoStepOnOlderDevices() {
        assertEquals(UnlockPath.Prompt(BIOMETRIC_STRONG or DEVICE_CREDENTIAL),
            planUnlock(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, 30, true, true))
        assertEquals(UnlockPath.Prompt(BIOMETRIC_STRONG, credentialButton = true),
            planUnlock(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, 29, true, true))
        assertEquals(UnlockPath.Prompt(BIOMETRIC_STRONG, credentialButton = true),
            planUnlock(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, 26, true, true))
    }

    @Test fun biometricWithFallbackUsesCredentialWhenNothingIsEnrolled() {
        assertEquals(UnlockPath.Prompt(DEVICE_CREDENTIAL), planUnlock(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, 34, false, true))
        assertEquals(UnlockPath.Keyguard(), planUnlock(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, 28, false, true))
    }

    @Test fun biometricOnlyNeverAllowsCredentialWhileBiometricsExist() {
        listOf(26, 29, 30, 35).forEach { sdk ->
            val path = planUnlock(UnlockMethod.BIOMETRIC_ONLY, sdk, true, true) as UnlockPath.Prompt
            assertEquals(BIOMETRIC_STRONG, path.authenticators)
            assertEquals(0, path.authenticators and DEVICE_CREDENTIAL)
            assertFalse(path.credentialButton)
        }
    }

    @Test fun removingAllBiometricsCannotPermanentlyLockOutABiometricOnlyUser() {
        val newer = planUnlock(UnlockMethod.BIOMETRIC_ONLY, 33, strongBiometricAvailable = false, deviceSecure = true)
        val older = planUnlock(UnlockMethod.BIOMETRIC_ONLY, 27, strongBiometricAvailable = false, deviceSecure = true)
        assertEquals(DEVICE_CREDENTIAL, (newer as UnlockPath.Prompt).authenticators)
        assertTrue(newer.notice!!.contains("No fingerprint or face"))
        assertTrue(older is UnlockPath.Keyguard)
        assertNotNull(older.notice)
    }

    @Test fun storedUnlockPolicyDefaultsSafelyAndRejectsUnknownValues() {
        assertEquals(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, UnlockMethod.fromStorage(null))
        assertEquals(UnlockMethod.BIOMETRIC_OR_CREDENTIAL, UnlockMethod.fromStorage("none"))
        UnlockMethod.entries.forEach { assertEquals(it, UnlockMethod.fromStorage(it.storageValue)) }
        assertEquals(UnlockMethod.entries.size, UnlockMethod.entries.map { it.storageValue }.toSet().size)
    }
}
