package cz.opentree.limessh

import cz.opentree.limessh.domain.model.AuthMethod
import cz.opentree.limessh.domain.model.Identity
import cz.opentree.limessh.ssh.AuthenticationFailure
import cz.opentree.limessh.ssh.InteractiveResponses
import cz.opentree.limessh.ssh.requireLoginIdentity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class AuthenticationTest {
    @Test fun missingIdentityNeverFallsBackToRoot() {
        val error = assertThrows(IllegalArgumentException::class.java) { requireLoginIdentity(null) }
        assertTrue(error.message!!.contains("select or create an identity"))
    }

    @Test fun blankUsernameIsRejectedAndWhitespaceAroundAUsernameIsRemoved() {
        assertThrows(IllegalArgumentException::class.java) { requireLoginIdentity(Identity(username = "  ")) }
        assertEquals("operator", requireLoginIdentity(Identity(username = " operator ")).username)
    }

    @Test fun interactivePasswordAutofillNeverAnswersAnOtpOrRepeatedPasswordChallenge() = runBlocking {
        val prompts = mutableListOf<String>()
        val responses = InteractiveResponses("stored-password", { false }) { prompt, _ ->
            prompts += prompt
            "user-response"
        }
        assertEquals("stored-password", responses.answer("Password:", false))
        assertEquals("user-response", responses.answer("Verification code:", false))
        assertEquals("user-response", responses.answer("Password:", false))
        assertEquals(listOf("Verification code:", "Password:"), prompts)
    }

    @Test fun completedFirstFactorAndEchoPromptsNeverReceiveTheStoredPassword() = runBlocking {
        val responses = InteractiveResponses("stored-password", { true }) { _, _ -> "second-factor" }
        assertEquals("second-factor", responses.answer("Password:", false))
        val echoed = InteractiveResponses("stored-password", { false }) { _, _ -> "visible-input" }
        assertEquals("visible-input", echoed.answer("Password:", true))
    }

    @Test fun failureExplainsRemainingMethodsWithoutShowingSecretsFromLibraryErrors() {
        val failure = AuthenticationFailure("operator", AuthMethod.PASSWORD, listOf("publickey"), false,
            IllegalStateException("private secret value"))
        assertTrue(failure.message!!.contains("operator"))
        assertTrue(failure.message!!.contains("not offering password login"))
        assertFalse(failure.message!!.contains("private secret value"))
    }
}
