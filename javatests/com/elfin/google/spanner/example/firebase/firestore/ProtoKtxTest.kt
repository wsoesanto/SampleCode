package com.elfin.google.spanner.example.firebase.firestore

import com.elfin.google.firebase.firestore.toMap
import com.elfin.google.firebase.store.Example
import com.elfin.google.firebase.store.SubExample
import com.elfin.google.firebase.store.example
import com.elfin.google.firebase.store.subExample
import com.google.common.collect.ImmutableMap
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProtoKtxTest {

  @Test
  fun toMap_exampleProtoWithEverythingPopulated_toProperMap() {
    val example = example {
      field = "field-1"
      field2 = subExample {
        this.field1 = 1
        this.field2 = 2.0f
      }
    }

    assertThat(example.toMap()).isEqualTo(ImmutableMap.builder<String, Any>()
                                            .put(Example.FIELD_FIELD_NUMBER.toString(), "field-1")
                                            .put(Example.FIELD_2_FIELD_NUMBER.toString(),
                                                 ImmutableMap.builder<String, Any>()
                                                   .put(SubExample.FIELD_1_FIELD_NUMBER.toString(),
                                                        1)
                                                   .put(SubExample.FIELD_2_FIELD_NUMBER.toString(),
                                                        2.0f).build())
                                            .build())
  }
}