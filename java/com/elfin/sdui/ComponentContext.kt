package com.elfin.sdui

interface ComponentContext<out BuilderT : ComponentBuilder> {
  val data: BuilderT
}
