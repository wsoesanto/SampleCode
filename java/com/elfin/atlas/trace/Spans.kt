package com.elfin.atlas.trace

import com.google.common.base.Preconditions.checkState
import io.opentelemetry.api.trace.Span
import io.opentelemetry.api.trace.SpanBuilder
import io.opentelemetry.api.trace.SpanKind
import io.opentelemetry.api.trace.StatusCode
import io.opentelemetry.api.trace.Tracer
import io.opentelemetry.context.Context
import io.opentelemetry.extension.kotlin.asContextElement
import kotlinx.coroutines.CoroutineScope

internal suspend fun <T> SpanBuilder.start(block: suspend (Span) -> T): T {
  val span = startSpan()
  try {
    span.makeCurrent().use {
      return block(span)
    }
  } catch (t: Throwable) {
    span.setStatus(StatusCode.ERROR).recordException(t)
    throw t
  } finally {
    span.end()
  }
}

suspend fun <T> Tracer.root(name: String, spanKind: SpanKind,
                            block: suspend (Span) -> T): T {
  checkState(Context.current() == Context.root(), "Please use span as you're within another span")
  return spanBuilder(name).setSpanKind(spanKind).start(block)
}

suspend fun <T> Tracer.span(name: String,
                            block: suspend (Span) -> T): T {
  val context = Context.current()
  checkState(context != Context.root(), "Please create a span root before creating a child span")
  return spanBuilder(name).setParent(context).start(block)
}

fun CoroutineScope.traced(): CoroutineScope {
  val context = Context.current()
  checkState(context != Context.root(), "Please create a span root before creating a child span")
  return CoroutineScope(this.coroutineContext + context.asContextElement())
}