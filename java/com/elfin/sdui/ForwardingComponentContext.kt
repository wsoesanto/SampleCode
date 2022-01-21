package com.elfin.sdui

class ForwardingComponentContext<BuilderT : ComponentBuilder> constructor(var delegate: ComponentContext<BuilderT>?) :
  ComponentContext<BuilderT> {
  override val data: BuilderT
    get() = delegate!!.data

}