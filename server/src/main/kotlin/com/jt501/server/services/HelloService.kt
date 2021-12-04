package com.jt501.server.services

import org.springframework.stereotype.Service

@Service("HelloRestService")
class HelloService {

    fun getHello(): String {
        return "hello service"
    }
}