package com.elfin.sdui.example

import com.elfin.sdui.Composer
import com.elfin.sdui.Container
import com.elfin.sdui.ContainerBuilder
import com.elfin.sdui.container
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  val composer = Composer()

  val container = Container()

  composer.compose { ctx ->
    container(ctx, {
      name = "Willy"
    }) { ctx ->
      (0 until 3).map { ctx.deferredChild<ContainerBuilder>() }
        .map { ctx -> async { 1 } }.awaitAll()
    }
  }
}