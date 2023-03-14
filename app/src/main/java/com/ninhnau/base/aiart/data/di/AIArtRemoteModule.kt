package com.ninhnau.base.aiart.data.di

import com.ninhnau.base.aiart.data.remote.service.AIArtService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AIArtRemoteModule {

    @Singleton
    @Provides
    fun provideAIArtService(retrofit: Retrofit): AIArtService {
        return retrofit.create(AIArtService::class.java)
    }
}