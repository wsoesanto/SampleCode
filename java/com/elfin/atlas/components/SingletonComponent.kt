package com.elfin.atlas.components

import com.elfin.atlas.CoroutineModule
import com.elfin.atlas.NetworkModule
import com.elfin.atlas.Rpc
import com.elfin.atlas.TraceModule
import dagger.Component
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.api.trace.Tracer
import io.opentelemetry.instrumentation.grpc.v1_6.GrpcTracing
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.Executor
import javax.inject.Singleton

@Singleton
@Component(modules = [CoroutineModule::class, NetworkModule::class, TraceModule::class])
interface SingletonComponent {

  @Rpc
  fun executor(): Executor

  fun grpcTracing(): GrpcTracing

  fun coroutineScope(): CoroutineScope

  fun tracer(): Tracer
}
