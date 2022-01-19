package com.elfin.atlas

import com.google.common.util.concurrent.ThreadFactoryBuilder
import dagger.Module
import dagger.Provides
import io.grpc.kotlin.GrpcContextElement
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Qualifier
import javax.inject.Singleton
import io.opentelemetry.extension.kotlin.asContextElement

@Module
object CoroutineModule {

  @JvmStatic
  @Provides
  @Singleton
  @Internal
  fun provideExecutor(): Executor = Executors.newFixedThreadPool(4,
                                                                 ThreadFactoryBuilder().setNameFormat(
                                                                   "coroutine-thread-%d").build())

  @JvmStatic
  @Provides
  @Singleton
  @Internal
  fun provideCoroutineDispatcher(
    @Internal executor: Executor): CoroutineDispatcher = executor.asCoroutineDispatcher()

  @JvmStatic
  @Provides
  fun provideCoroutineScope(
    @Internal coroutineDispatcher: CoroutineDispatcher): CoroutineScope = CoroutineScope(
    GrpcContextElement.current() + coroutineDispatcher + SupervisorJob())

  @Qualifier
  annotation class Internal
}