package com.marcofabbian.chatbot.prompt

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

data class PromptSpec(
    val id: String? = null,
    val version: String? = null,
    val owner: String? = null,
    val updatedAt: String? = null,
    val changeReason: String? = null,
    val content: String? = null
) {
    fun sha256(): String {
        val digest = MessageDigest.getInstance("SHA-256")
            .digest(content.orEmpty().toByteArray(StandardCharsets.UTF_8))
        return digest.joinToString("") { "%02x".format(it) }
    }

    fun validate() {
        require(!id.isNullOrBlank()) { "Prompt metadata invalid: id is required" }
        require(!version.isNullOrBlank()) { "Prompt metadata invalid: version is required" }
        require(!owner.isNullOrBlank()) { "Prompt metadata invalid: owner is required" }
        require(!content.isNullOrBlank()) { "Prompt metadata invalid: content is required" }
    }
}

