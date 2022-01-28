package com.elfin.google.firebase

import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.cloud.FirestoreClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FirestoreModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideFirestore(firebaseApp: FirebaseApp): Firestore {
        return FirestoreClient.getFirestore(firebaseApp)
    }
}