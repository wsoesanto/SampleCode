package com.elfin.sdui

class LeafComponentContext<out BuilderT : ComponentBuilder> constructor(override val data: BuilderT) :
  ComponentContext<BuilderT> {

}