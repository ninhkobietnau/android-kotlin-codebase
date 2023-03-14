package com.ninhnau.base.aiart.data.di

import android.content.Context
import com.ninhnau.base.aiart.data.local.AppDatabase
import com.ninhnau.base.aiart.data.local.dao.ImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AIArtLocalModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.buildDatabase(context)

    @Singleton
    @Provides
    fun provideImageDao(database: AppDatabase): ImageDao = database.imageDao()
}