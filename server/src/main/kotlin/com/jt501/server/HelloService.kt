package com.jt501.server

import com.jt501.services.hello.HelloReply
import com.jt501.services.hello.HelloRequest
import com.jt501.services.hello.HelloServiceGrpcKt
import com.jt501.services.hello.helloReply
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.devh.boot.grpc.server.service.GrpcService
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime


@GrpcService
class HelloService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {

    override suspend fun sayHello(request: HelloRequest) = helloReply {
        message = "Hello ${request.name}"
    }

    @OptIn(ExperimentalTime::class)
    override fun streamHello(request: HelloRequest): Flow<HelloReply> {
        return flow {
            emit(helloReply { message = "Hello ${request.name}" })
            delay(1.0.seconds)
            emit(helloReply { message = "How are you ?" })
            delay(2.0.seconds)
            emit(helloReply { message = "I'm fine, thank you !" })
        }
    }
}