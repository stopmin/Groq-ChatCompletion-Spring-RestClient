package minlab.groqcloud.domain

import minlab.groqcloud.domain.Developer.GOOGLE
import minlab.groqcloud.domain.Developer.META
import minlab.groqcloud.domain.Developer.MISTRAL

enum class GroqSuppliedModel(val id: String, val developer: Developer) {
    MIXTRAL_8X7B("mixtral-8x7b-32768", MISTRAL),
    LLAMA3_8B("llama3-8b-8192", META),
    LLAMA3_70B("llama3-70b-8192", META),
    LLAMA2_70B("llama2-70b-4096", META),
    GEMMA_7B("gemma-7b-it", GOOGLE)
}

enum class Developer(name: String) {
    MISTRAL("Mistral"),
    META("META"),
    GOOGLE("Google")
}
