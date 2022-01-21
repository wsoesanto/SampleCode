@file:JvmName("Main")
@file:JvmMultifileClass

package com.elfin.atlas.example

import com.elfin.atlas.components.DaggerSingletonComponent
import com.elfin.atlas.components.SingletonComponent
import com.elfin.atlas.trace.root
import com.elfin.atlas.trace.span
import com.elfin.atlas.trace.traced
import com.google.common.flogger.FluentLogger
import com.hermes.example.*
import io.grpc.ServerBuilder
import io.grpc.Status
import io.grpc.StatusException
import io.grpc.stub.StreamObserver
import io.opentelemetry.api.trace.SpanKind
import io.opentelemetry.api.trace.Tracer
import io.opentelemetry.context.propagation.TextMapPropagator
import kotlinx.coroutines.*
import javax.inject.Inject

val logger = FluentLogger.forEnclosingClass()

class HelloWorldAction @Inject constructor(private val tracer: Tracer,
                                           private val coroutineScope: CoroutineScope) {

  suspend fun execute(req: SayHelloRequest): SayHelloResponse {
    val (a, b) = awaitAll(
      coroutineScope.traced().async {
        tracer.span("MakingFakeHeavyCall") {
          delay(1000)
        }
        1
      },
      coroutineScope.traced().async {
        tracer.span("MakingFakeLighterCall") {
          delay(500)
        }
        2
      })

    return sayHelloResponse {
      name = "Muahaha ${a + b}"
    }
  }
}

class HelloWorldImpl(private val singletonComponent: SingletonComponent) :
  HelloWorldServiceGrpcKt.HelloWorldServiceCoroutineImplBase(singletonComponent.executor().asCoroutineDispatcher()) {

  override suspend fun sayHello(request: SayHelloRequest): SayHelloResponse {
    logger.atInfo().log("LGOKOK")
    return withContext(singletonComponent.coroutineScope().coroutineContext) {
//      val tracer = singletonComponent.tracer()
//      tracer
//        .root(HelloWorldServiceGrpcKt.sayHelloMethod.fullMethodName, SpanKind.SERVER) {
          try {
            supervisorScope {
              HelloWorldAction(singletonComponent.tracer(), this).execute(request)
            }
          } catch (e: Throwable) {
            logger.atSevere().withCause(e).log("Internal error.")
            throw StatusException(Status.INTERNAL.withCause(e).withDescription("Internal error."))
          }
//        }
    }
  }
}

fun main(args: Array<String>) {
  TextMapPropagator::class.toString();
  val singleton = DaggerSingletonComponent.create()

  ServerBuilder.forPort(9090)
    .addService(HelloWorldImpl(singleton))
    .intercept(singleton.grpcTracing().newServerInterceptor())
    .executor(singleton.executor())
    .build()
    .start().awaitTermination()
}