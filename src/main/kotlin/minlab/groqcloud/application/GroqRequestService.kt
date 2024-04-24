package minlab.groqcloud.application

import minlab.groqcloud.domain.GroqSuppliedModel
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Service
class GroqRequestService(
    private val restClient: RestClient
) {
    @Value("\${groq_api_key}")
    lateinit var groqApiKey: String

    @Value("\${groq_request_url}")
    lateinit var groqRequestUrl: String
    fun groqRequest(message: String): String? {
        val request = mapOf(
            "messages" to listOf(
                mapOf(
                    "role" to "user",
                    "content" to message
                )
            ),
            "model" to GroqSuppliedModel.LLAMA3_70B.id
        )

        return postRequest(groqRequestUrl, request).body<String>()
    }

    fun postRequest(uri: String, requestDTO: Any): RestClient.ResponseSpec {
        return restClient.post()
            .uri(uri)
            .header(
                "Authorization",
                "Bearer ${groqApiKey}"
            )
            .header("Content-Type", "application/json")
            .contentType(MediaType.APPLICATION_JSON)
            .body(requestDTO)
            .retrieve()
    }
}
