package com.elfin.google

import com.google.auth.oauth2.GoogleCredentials
import dagger.Module
import dagger.Provides
import java.io.FileInputStream

@Module
object GoogleCloudModule {

    @JvmStatic
    @Provides
    fun provideGoogleCredentials(): GoogleCredentials {
        return GoogleCredentials.fromStream(FileInputStream("java/com/elfin/google/service_account.json"))
    }
}