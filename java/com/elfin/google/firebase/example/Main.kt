package com.elfin.google.firebase.example

import com.elfin.google.asDeferred
import com.google.api.core.ApiFutures
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.Query

class Main constructor(val firestore: Firestore) {

    suspend fun run() {
        firestore.runAsyncTransaction({ txn ->
            txn.get(
                Query.fromProto(
                    firestore,
                    com.google.firestore.v1.RunQueryRequest.newBuilder().build()
                )
            )
        }).asDeferred().await()
    }

}