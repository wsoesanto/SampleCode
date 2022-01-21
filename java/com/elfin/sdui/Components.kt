package com.elfin.sdui

class Container {

  suspend operator fun invoke(
    forwardingComponentContext: ForwardingComponentContext<ContainerBuilder>,
    setUpDebugCtx: suspend DebugContext.() -> Unit = {},
    setUpChildren: suspend (BranchComponentContext<ContainerBuilder>) -> Unit = {},
  ) {
    val ctx = BranchComponentContext(ContainerBuilder())
    forwardingComponentContext.delegate = ctx

    setUpDebugCtx(ctx.debug)

    setUpChildren(ctx)
  }

  suspend operator fun invoke(
    parent: BranchComponentContext<*>,
    setUpDebugCtx: suspend DebugContext.() -> Unit = {},
    setUpChildren: suspend (BranchComponentContext<ContainerBuilder>) -> Unit = {},
  ) {
    container(parent.deferredChild(), setUpDebugCtx, setUpChildren)
  }
}