package com.marcofabbian.chatbot.prompt

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PromptService(
    private val loader: PromptLoader,
    private val auditLogger: PromptAuditLogger
) {
    private val answerDefault: PromptSpec = loader.load("prompts/answer-default.yaml")

    fun renderSystemPrompt(referencePassages: String, requestId: String = UUID.randomUUID().toString()): String {
        auditLogger.logPromptUse(requestId, answerDefault)
        return answerDefault.content.orEmpty().replace("{{reference_passages}}", referencePassages)
    }
}

