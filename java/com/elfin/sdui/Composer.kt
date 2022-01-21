package com.elfin.sdui

class Composer {

  suspend fun compose(compose: suspend (ctx: BranchComponentContext<*>) -> Unit) {
    val root = BranchComponentContext(RootBuilder)
    compose(root)
  }
}
