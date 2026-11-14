package com.marcofabbian.chatbot.prompt

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PromptServiceTest {
    private val service = PromptService(PromptLoader(), PromptAuditLogger())

    @Test
    fun `renders system prompt by injecting reference passages`() {
        val output = service.renderSystemPrompt("[How to Invest Money p.91]\nMunicipal bonds ...", "test-request-id")
        assertTrue(output.contains("<reference_passages>"))
        assertTrue(output.contains("Municipal bonds"))
        assertFalse(output.contains("{{reference_passages}}"))
    }
}

