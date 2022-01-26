@file:JvmName("Main")

package com.elfin.google.spanner.example

import com.google.cloud.spanner.AsyncResultSet
import com.google.cloud.spanner.DatabaseClient
import com.google.cloud.spanner.DatabaseId
import com.google.cloud.spanner.Spanner
import com.google.cloud.spanner.SpannerOptions
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.runBlocking
import com.google.api.core.ApiFuture
import com.google.api.core.ApiFutureToListenableFuture
import com.google.cloud.Service
import com.google.cloud.ServiceOptions
import com.google.common.util.concurrent.MoreExecutors
import javax.print.attribute.IntegerSyntax
import kotlinx.coroutines.guava.asDeferred
import kotlinx.coroutines.guava.await

fun <T> ApiFuture<T>.asDeferred() : Deferred<T> {
  return ApiFutureToListenableFuture(this).asDeferred()
}

suspend fun <T> ApiFuture<T>.await() : T {
  return ApiFutureToListenableFuture(this).await()
}

class AsyncReadTransactionExample(private val databaseClient: DatabaseClient) {

  suspend fun read() {
    databaseClient.transactionManagerAsync().use {
      val txn = it.beginAsync().await()

    }
  }
}

//typealias Spanner = Service<SpannerOptions>

fun main() = runBlocking {

  // TODO(developer): Replace these variables before running the sample.
  val projectId = "my-project";
  val instanceId = "my-instance";
  val databaseId = "my-database";

  val spanner: Spanner = SpannerOptions.newBuilder().setProjectId(projectId).build().getService()
  spanner.getDatabaseClient(DatabaseId.of("my-database"))
//  spanner.
//      .use {
//    DatabaseClient client =
//    spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));
}