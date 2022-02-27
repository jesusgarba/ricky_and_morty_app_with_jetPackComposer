package com.example.rickandmorty.di

import com.example.rickandmorty.provider.RickyMortyProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProviderModule {
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://rickandmortyapi.com/api/".toHttpUrl()

    @Singleton
    @Provides
    fun providerRetrofit(@Named("BaseUrl") baseUrl: HttpUrl): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun providerCharacterProvider(retrofit: Retrofit): RickyMortyProvider = retrofit.create(RickyMortyProvider::class.java)
}