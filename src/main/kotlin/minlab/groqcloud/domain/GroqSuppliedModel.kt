package minlab.groqcloud.domain

enum class GroqSuppliedModel(val id: String, val developer: String) {
    MIXTRAL_8X7B("mixtral-8x7b-32768", "Mistral"),
    LLAMA3_8B("llama3-8b-8192", "META"),
    LLAMA3_70B("llama3-70b-8192", "META"),
    LLAMA2_70B("llama2-70b-4096", "Meta"),
    GEMMA_7B("gemma-7b-it", "Google")
}
