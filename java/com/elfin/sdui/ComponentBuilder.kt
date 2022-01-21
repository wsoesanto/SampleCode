package com.elfin.sdui

interface ComponentBuilder {

  fun build(parent: ComponentBuilder, children: List<ComponentBuilder>)
}