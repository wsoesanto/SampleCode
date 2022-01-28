package com.elfin.google.firebase.firestore

import com.google.common.collect.ImmutableMap
import com.google.protobuf.Descriptors
import com.google.protobuf.Message

fun Message.toMap(): Map<String, Any> {
  val builder = ImmutableMap.builder<String, Any>()
  for (field in this.allFields) {
    builder.put(field.key.number.toString(),
                when (field.key.type) {
                  Descriptors.FieldDescriptor.Type.MESSAGE -> {
                    val message = (field.value as Message)
                    if (message.defaultInstanceForType == message) {
                      continue
                    }
                    message.toMap()
                  }
                  else -> {
                    field.value
                  }
                })
  }
  return builder.build()
}