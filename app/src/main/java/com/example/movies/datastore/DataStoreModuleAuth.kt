package com.example.movies.datastore

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    fun provideDataStoreManagerAuth(@ApplicationContext context: Context): DataStoreManagerAuth {
        return DataStoreManagerAuth(context)
    }
}
