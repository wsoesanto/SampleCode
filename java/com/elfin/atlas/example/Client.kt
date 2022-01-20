@file:JvmName(name = "Client")
@file:JvmMultifileClass

package com.elfin.atlas.example

import com.elfin.atlas.components.DaggerSingletonComponent
import com.elfin.atlas.trace.root
import com.hermes.example.HelloWorldServiceGrpcKt
import io.opentelemetry.api.trace.SpanKind
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
  val component = DaggerSingletonComponent.create()

  component.tracer().root("RootFromClient", SpanKind.CLIENT) {
//    HelloWorldServiceGrpcKt.HelloWorldServiceCoroutineStub(InProcess)
  }
}