package cz.opentree.limessh.ui.screens

import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.ui.lock.UnlockPath
import cz.opentree.limessh.ui.lock.planUnlock

private tailrec fun Context.findFragmentActivity(): FragmentActivity? = when (this) {
    is FragmentActivity -> this
    is ContextWrapper -> baseContext.findFragmentActivity()
    else -> null
}

/**
 * App lock screen. The policy comes from Settings: device credential, strong
 * biometric with credential fallback, or strong biometric only. Locking hides the
 * UI and blocks new plugin/automation requests; open SSH transports continue.
 */
@Composable
fun InactivityLockScreen(onUnlocked: () -> Unit) {
    val context = LocalContext.current
    val activity = remember(context) { context.findFragmentActivity() }
    val app = context.applicationContext as LimeApp
    val preferences by app.settings.preferences.collectAsState()
    var message by remember { mutableStateOf("Authenticate to continue.") }
    var attemptedAutomatically by remember { mutableStateOf(false) }
    val keyguardLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) onUnlocked()
        else message = "Authentication was cancelled. limessh remains locked."
    }

    fun launchKeyguard() {
        val keyguard = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        @Suppress("DEPRECATION")
        val intent = keyguard.createConfirmDeviceCredentialIntent("Unlock limessh", "Authenticate to access SSH sessions")
        if (intent != null) keyguardLauncher.launch(intent)
        else message = "Android cannot show the screen-lock prompt. Set a screen lock in Android Settings."
    }

    fun authenticate() {
        val host = activity
        val manager = BiometricManager.from(context)
        val strongBiometric = manager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG) ==
            BiometricManager.BIOMETRIC_SUCCESS
        val keyguard = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        when (val path = planUnlock(preferences.unlockMethod, Build.VERSION.SDK_INT, strongBiometric, keyguard.isDeviceSecure)) {
            is UnlockPath.Unavailable -> message = path.reason
            is UnlockPath.Keyguard -> { path.notice?.let { message = it }; launchKeyguard() }
            is UnlockPath.Prompt -> {
                if (host == null) { message = "This screen cannot show the biometric prompt."; return }
                path.notice?.let { message = it }
                val callback = object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) = onUnlocked()
                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                        when (errorCode) {
                            BiometricPrompt.ERROR_NEGATIVE_BUTTON -> if (path.credentialButton) launchKeyguard()
                                else message = "Authentication was cancelled. limessh remains locked."
                            BiometricPrompt.ERROR_USER_CANCELED, BiometricPrompt.ERROR_CANCELED ->
                                message = "Authentication was cancelled. limessh remains locked."
                            else -> message = errString.toString()
                        }
                    }
                }
                val info = BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Unlock limessh")
                    .setSubtitle("Authenticate to access SSH sessions")
                    .setAllowedAuthenticators(path.authenticators)
                    .apply {
                        // A negative button is only valid when device credential is not an allowed authenticator.
                        if (path.authenticators and BiometricManager.Authenticators.DEVICE_CREDENTIAL == 0) {
                            setNegativeButtonText(if (path.credentialButton) "Use screen lock" else "Cancel")
                        }
                    }
                    .build()
                BiometricPrompt(host, ContextCompat.getMainExecutor(context), callback).authenticate(info)
            }
        }
    }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    LaunchedEffect(lifecycle) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            if (!attemptedAutomatically) {
                attemptedAutomatically = true
                authenticate()
            }
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("limessh locked", style = MaterialTheme.typography.headlineMedium)
            Text(message)
            Button(onClick = { authenticate() }) { Text("Unlock") }
        }
    }
}
