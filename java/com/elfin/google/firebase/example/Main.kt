package com.elfin.google.firebase.example

import com.google.cloud.firestore.Firestore

class Main constructor(val firestore: Firestore) {

  suspend fun run() {
    val account = account {
      id = accountId { literal = 1 }
      registrationTime = timestamp {
        literal = 100
      }
    }
  }

}