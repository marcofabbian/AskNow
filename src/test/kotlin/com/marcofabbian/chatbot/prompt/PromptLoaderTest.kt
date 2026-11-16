package com.marcofabbian.chatbot.prompt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PromptLoaderTest {
    private val loader = PromptLoader()

    @Test
    fun `loads prompt with required metadata`() {
        val prompt = loader.load("prompts/answer-default.yaml")
        assertEquals("answer-default", prompt.id)
        assertTrue(prompt.version!!.isNotBlank())
        assertTrue(prompt.content!!.contains("{{reference_passages}}"))
    }
}

