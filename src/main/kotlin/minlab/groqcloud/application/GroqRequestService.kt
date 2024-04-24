package minlab.groqcloud.application

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Service
class GroqRequestService(
    private val restClient: RestClient
) {
    fun postRequest(uri: String, requestDTO: Any): RestClient.ResponseSpec {
        return restClient.post()
            .uri(uri)
            .header(
                "Authorization",
                "Bearer ${""}"
            )
            .header("Content-Type", "application/json")
            .contentType(MediaType.APPLICATION_JSON)
            .body(requestDTO)
            .retrieve()
    }
}

fun main() {
    val request = mapOf(
        "messages" to listOf(
            mapOf(
                "role" to "user",
                "content" to "Explain the importance of fast language models"
            )
        ),
        "model" to "mixtral-8x7b-32768"
    )


    val groqRequestService = GroqRequestService(RestClient.create())
    val response = groqRequestService.postRequest("https://api.groq.com/openai/v1/chat/completions", request)
    println(response.body<String>())
}
