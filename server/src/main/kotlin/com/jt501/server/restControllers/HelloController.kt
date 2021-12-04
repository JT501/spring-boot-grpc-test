package com.jt501.server.restControllers

import com.jt501.server.services.HelloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(@Autowired val helloService: HelloService) {
    data class HelloDto(val greeting: String)

    @GetMapping("/hello-service")
    fun helloKotlinService(): String = helloService.getHello()

    @GetMapping("/hello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("Hello from the dto")
    }
}