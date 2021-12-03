package com.jt501.server

import com.jt501.services.hello.HelloReply
import com.jt501.services.hello.HelloRequest
import com.jt501.services.hello.HelloServiceGrpcKt
import net.devh.boot.grpc.server.service.GrpcService


@GrpcService
class HelloService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {

    override suspend fun sayHello(request: HelloRequest): HelloReply {
        return HelloReply.newBuilder().setMessage("Hello ==> " + request.name).build()
    }
}