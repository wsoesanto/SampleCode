@file:JvmName("Main")
@file:JvmMultifileClass

package com.elfin.atlas.example

import com.hermes.example.HelloWorldServiceGrpcKt
import com.hermes.example.SayHelloRequest
import com.hermes.example.SayHelloResponse
import com.hermes.example.sayHelloResponse
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver

class HelloWorldImplementation : HelloWorldServiceGrpcKt.HelloWorldServiceCoroutineImplBase() {
  override suspend fun sayHello(request: SayHelloRequest): SayHelloResponse {
    return sayHelloResponse {
      name = "Muahaha"
    }
  }
}

fun main(args: Array<String>) {
  val serverBuilder = ServerBuilder.forPort(9090)
  serverBuilder.addService(HelloWorldImplementation())
  serverBuilder.build().start().awaitTermination()
}