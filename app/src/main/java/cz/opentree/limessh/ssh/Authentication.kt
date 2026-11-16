package cz.opentree.limessh.ssh

import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.domain.model.Identity

internal fun requireLoginIdentity(identity: Identity?): Identity {
    requireNotNull(identity) { "No login identity is assigned. Edit this connection and select or create an identity." }
    val username = identity.username.trim()
    require(username.isNotEmpty()) { "The selected identity has no SSH username. Edit the identity before connecting." }
    return identity.copy(username = username)
}

/** Secrets and raw library/server error messages are deliberately excluded. */
class AuthenticationFailure(
    username: String,
    method: AuthMethod,
    remainingMethods: Collection<String>,
    partialSuccess: Boolean,
    cause: Throwable,
) : Exception(buildString {
    append("SSH authentication failed for user '$username' using ")
    append(when (method) {
        AuthMethod.PASSWORD -> "password / keyboard-interactive"
        AuthMethod.PUBLIC_KEY -> "private key"
        AuthMethod.KEYBOARD_INTERACTIVE -> "keyboard-interactive"
    })
    append(".\n")
    if (partialSuccess) append("One factor was accepted, but the server requires another.\n")
    val allowed = remainingMethods.filter { it.matches(Regex("[a-zA-Z0-9@._+-]{1,64}")) }.distinct().sorted()
    if (allowed.isNotEmpty()) append("Server reports remaining methods: ${allowed.joinToString(", ")}.\n")
    append(when {
        method == AuthMethod.PASSWORD && allowed.isNotEmpty() && allowed.none { it == "password" || it == "keyboard-interactive" } ->
            "This server is not offering password login. Select an authorized private-key identity."
        method == AuthMethod.PUBLIC_KEY && !partialSuccess ->
            "Verify the SSH username and that this key's public key is authorized for that account."
        else -> "Check the selected identity, username and credentials. The server may require a second factor or disallow this account."
    })
}, cause)

/** Auto-fill only one unambiguous password prompt; ask the user for OTPs/retries. */
internal class InteractiveResponses(
    private val password: String?,
    private val partialSuccess: () -> Boolean,
    private val respond: suspend (String, Boolean) -> String,
) {
    private var passwordUsed = false
    suspend fun answer(prompt: String, echo: Boolean): String {
        val passwordPrompt = prompt.trim().matches(Regex("(?i)^(?:[\\w.@-]+(?:'s)?\\s+)?password\\s*:\\s*$"))
        if (!echo && passwordPrompt && !passwordUsed && !partialSuccess() && !password.isNullOrEmpty()) {
            passwordUsed = true
            return password
        }
        return respond(prompt, echo)
    }
}
