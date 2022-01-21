package com.elfin.sdui

class BranchComponentContext<out BuilderT : ComponentBuilder> constructor(override val data: BuilderT) :
  ComponentContext<BuilderT> {

  private val children = mutableListOf<ComponentContext<*>>()

  fun children(): List<ComponentContext<*>> = children

  fun <DeferredBuilderT : ComponentBuilder> deferredChild(): ForwardingComponentContext<DeferredBuilderT> {
    val deferredChild = ForwardingComponentContext<DeferredBuilderT>(null)
    children.add(deferredChild)
    return deferredChild
  }

  var debug = DebugContext()
}