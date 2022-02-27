package com.example.rickandmorty.di

import com.example.rickandmorty.data.repository.RickyMortyRepository
import com.example.rickandmorty.data.repository.RickyMortyRepositoryImp
import com.example.rickandmorty.provider.RickyMortyProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providerRickyMortyRepository(provider: RickyMortyProvider): RickyMortyRepository = RickyMortyRepositoryImp(provider)
}