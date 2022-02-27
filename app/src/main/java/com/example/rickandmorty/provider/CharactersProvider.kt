package com.example.rickandmorty.provider

import com.example.rickandmorty.data.Character
import com.example.rickandmorty.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickyMortyProvider {
    @GET("character")
    suspend fun characters(): Response<ApiResponse>
}