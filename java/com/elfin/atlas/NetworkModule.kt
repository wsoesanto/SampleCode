package com.elfin.atlas

import com.google.common.util.concurrent.ThreadFactoryBuilder
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
object NetworkModule {

    @JvmStatic
    @Provides
    @Rpc
    @Singleton
    fun provideExecutor(): Executor = Executors.newFixedThreadPool(4,
                                                                   ThreadFactoryBuilder().setNameFormat(
                                                                     "grpc-thread-%d").build())
}