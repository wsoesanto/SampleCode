package com.elfin.atlas.example

import dagger.Module
import dagger.Provides

@Module
class SimpleModule {

  companion object {

    @Provides
    @JvmStatic
    fun provideName(): String = "Willy"
  }
}