package minlab.groqcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GroqcloudApplication

fun main(args: Array<String>) {
	runApplication<GroqcloudApplication>(*args)
}
