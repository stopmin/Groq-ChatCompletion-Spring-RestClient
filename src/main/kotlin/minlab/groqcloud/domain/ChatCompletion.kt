package minlab.groqcloud.domain


data class ChatCompletion(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<Choice>,
    val usage: Usage,
    val system_fingerprint: String,
    val x_groq: XGroq
)

data class Choice(
    val index: Int,
    val message: Message,
    val logprobs: String? = null, // Assuming nullable since "null" is in your example.
    val finish_reason: String
)

data class Message(
    val role: String,
    val content: String
)

data class Usage(
    val prompt_tokens: Int,
    val prompt_time: Double,
    val completion_tokens: Int,
    val completion_time: Double,
    val total_tokens: Int,
    val total_time: Double
)

data class XGroq(
    val id: String
)
