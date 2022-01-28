package com.elfin.google

import com.google.api.core.ApiFuture
import com.google.api.core.ApiFutureToListenableFuture
import com.google.api.core.ApiFutures
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.guava.asDeferred

fun <T> ApiFuture<T>.asDeferred(): Deferred<T> {
    return ApiFutureToListenableFuture(this).asDeferred()
}