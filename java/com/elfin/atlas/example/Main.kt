@file:JvmName("Main")
@file:JvmMultifileClass

package com.elfin.atlas.example

import com.hermes.example.HelloWorldServiceGrpc
import com.hermes.example.SayHelloRequest
import com.hermes.example.SayHelloResponse
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver

class HelloWorldImplementation : HelloWorldServiceGrpc.HelloWorldServiceImplBase() {

  override fun sayHello(request: SayHelloRequest,
                        responseObserver: StreamObserver<SayHelloResponse>) {
    responseObserver.onNext(SayHelloResponse.newBuilder().setName("Muahaha").build())
    responseObserver.onCompleted()
  }
}

fun main(args: Array<String>) {
  val serverBuilder = ServerBuilder.forPort(9090)
  serverBuilder.addService(HelloWorldImplementation())
  serverBuilder.build().start().awaitTermination()
}