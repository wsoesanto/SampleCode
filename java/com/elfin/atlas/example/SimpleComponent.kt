package com.elfin.atlas.example

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SimpleModule::class])
interface SimpleComponent {

  fun name(): String
}