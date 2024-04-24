package minlab.groqcloud.presentation

import minlab.groqcloud.application.GroqRequestService
import minlab.groqcloud.common.ResultDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GroqRequestController(
    private val groqRequestService: GroqRequestService
) {
    @PostMapping("/v1/groqcloud/request")
    fun groqRequest(@RequestBody groqRequestDTO: GroqRequestDTO): ResponseEntity<ResultDTO> {
        val response = groqRequestService.groqRequest(groqRequestDTO.message)

        return ResponseEntity.ok(
            ResultDTO(
                result = true,
                message = "Request sent successfully",
                data = response
            )
        )
    }
}

data class GroqRequestDTO(
    val message: String
)
