package com.elfin.atlas

import dagger.Module
import dagger.Provides
import io.opentelemetry.api.OpenTelemetry
import io.opentelemetry.api.trace.Tracer
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator
import io.opentelemetry.context.propagation.ContextPropagators
import io.opentelemetry.exporters.logging.LoggingSpanExporter
import io.opentelemetry.instrumentation.grpc.v1_6.GrpcTracing
import io.opentelemetry.sdk.OpenTelemetrySdk
import io.opentelemetry.sdk.trace.SdkTracerProvider
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class TraceModule {

  companion object {
    @JvmStatic
    @Provides
    @Singleton
    @Internal
    fun provideOpenTelemetry(): OpenTelemetry {
      return OpenTelemetrySdk.builder()
        .setTracerProvider(SdkTracerProvider.builder()
                             .addSpanProcessor(SimpleSpanProcessor.create(LoggingSpanExporter()))
                             .build())
        .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
        .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideGrpcTracing(
      @Internal openTelemetry: OpenTelemetry): GrpcTracing {
      return GrpcTracing.create(openTelemetry)
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideTracer(@Internal openTelemetry: OpenTelemetry): Tracer {
      return openTelemetry.getTracer("elfin")
    }

    @Qualifier
    annotation class Internal
  }
}