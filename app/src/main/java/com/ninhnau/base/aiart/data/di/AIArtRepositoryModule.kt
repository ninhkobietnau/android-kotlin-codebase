package com.ninhnau.base.aiart.data.di

import com.ninhnau.base.aiart.data.repository.AIArtRepositoryImpl
import com.ninhnau.base.aiart.domain.repository.AIArtRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AIArtRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAIArtRepository(impl: AIArtRepositoryImpl): AIArtRepository
}