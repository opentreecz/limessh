package cz.opentree.limessh.plugin.automation

import android.content.Context
import cz.opentree.limessh.data.local.crypto.CredentialStore
import java.security.SecureRandom
import java.util.Base64
import java.util.UUID

/** Scoped bearer grants created only by the interactive Tasker configuration activity. */
class AutomationGrants(context: Context) {
    private val store = CredentialStore(context)

    fun create(connectionId: UUID, snippetId: UUID): String {
        val token = Base64.getUrlEncoder().withoutPadding().encodeToString(ByteArray(32).also { SecureRandom().nextBytes(it) })
        store.storeAutomationGrant(digest(token), "$connectionId:$snippetId")
        return token
    }

    fun resolve(token: String): Pair<UUID, UUID>? {
        if (!token.matches(Regex("[A-Za-z0-9_-]{43}"))) return null
        return resolveDigest(digest(token))
    }

    fun resolveDigest(digest: String): Pair<UUID, UUID>? {
        if (!digest.matches(Regex("[0-9a-f]{64}"))) return null
        val value = store.getAutomationGrant(digest) ?: return null
        val parts = value.split(":")
        return runCatching { UUID.fromString(parts[0]) to UUID.fromString(parts[1]) }.getOrNull()
    }

    fun revokeAll() = store.deleteAutomationGrants()

    companion object {
        fun digest(token: String): String = java.security.MessageDigest.getInstance("SHA-256")
            .digest(token.toByteArray(Charsets.UTF_8)).joinToString("") { "%02x".format(it) }
        const val EXTRA_BUNDLE = "com.twofortyfouram.locale.intent.extra.BUNDLE"
        const val EXTRA_BLURB = "com.twofortyfouram.locale.intent.extra.BLURB"
        const val TOKEN = "cz.opentree.limessh.automation.TOKEN"
    }
}
