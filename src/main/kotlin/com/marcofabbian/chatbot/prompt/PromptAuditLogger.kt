package com.marcofabbian.chatbot.prompt

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class PromptAuditLogger {
    private val logger = LoggerFactory.getLogger(PromptAuditLogger::class.java)

    fun logPromptUse(requestId: String, prompt: PromptSpec) {
        logger.info(
            "prompt_use requestId={} promptId={} version={} sha256={}",
            requestId,
            prompt.id,
            prompt.version,
            prompt.sha256()
        )
    }
}

