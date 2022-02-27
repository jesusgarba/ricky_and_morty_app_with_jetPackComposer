package com.example.rickandmorty

import android.util.Log
import com.example.rickandmorty.data.repository.RickyMortyRepositoryImp
import com.example.rickandmorty.provider.RickyMortyProvider
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.nio.charset.StandardCharsets

class RickyMortyRepositoryTest {

    private val mockWebServer = MockWebServer()

    private val rickyMortyProvider = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RickyMortyProvider::class.java)

    private val rickyMortyRepository = RickyMortyRepositoryImp(rickyMortyProvider)

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun `All characters response is correct`(){
        mockWebServer.enqueueResponse("characters.json")

        runBlocking {
            val characters = rickyMortyRepository.getCharacters()
            assertEquals(20, characters.size)
            assertEquals("Rick Sanchez", characters[0].name)
            assertEquals("Ants in my Eyes Johnson", characters[19].name)
        }
    }
}

fun MockWebServer.enqueueResponse(filePath: String){
    val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
    val source =  inputStream?.source()?.buffer()
    source?.let{
        enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(it.readString(StandardCharsets.UTF_8))
        )

    }
}


