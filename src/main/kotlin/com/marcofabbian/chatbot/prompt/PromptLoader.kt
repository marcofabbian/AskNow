package com.marcofabbian.chatbot.prompt

import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import org.yaml.snakeyaml.Yaml

@Component
class PromptLoader {
    @Suppress("UNCHECKED_CAST")
    fun load(classpathFile: String): PromptSpec {
        return try {
            ClassPathResource(classpathFile).inputStream.use { input ->
                val raw = Yaml().load<Map<String, Any?>>(input) ?: emptyMap()
                val prompt = PromptSpec(
                    id = raw["id"] as? String,
                    version = raw["version"] as? String,
                    owner = raw["owner"] as? String,
                    updatedAt = raw["updatedAt"] as? String,
                    changeReason = raw["changeReason"] as? String,
                    content = raw["content"] as? String
                )
                prompt.validate()
                prompt
            }
        } catch (e: Exception) {
            throw IllegalStateException("Failed to load prompt from $classpathFile", e)
        }
    }
}

