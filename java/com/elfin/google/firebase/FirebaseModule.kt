package com.elfin.google.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FirebaseModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideFirebaseApp(credentials: GoogleCredentials): FirebaseApp {
        return FirebaseApp.initializeApp(
            FirebaseOptions.builder().setCredentials(credentials).build()
        )
    }
}