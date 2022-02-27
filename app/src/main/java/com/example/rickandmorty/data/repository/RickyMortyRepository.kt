package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.Character
import com.example.rickandmorty.provider.RickyMortyProvider
import javax.inject.Inject

interface RickyMortyRepository {
    suspend fun getCharacters(): List<Character>
    fun getCharacter(id: Int) : Character
}


class RickyMortyRepositoryImp
@Inject constructor(private val rickyMortyProvider: RickyMortyProvider): RickyMortyRepository{

    private var characters: MutableList<Character> = emptyList<Character>().toMutableList()

    override suspend fun getCharacters(): List<Character> {
        val apiResponse = rickyMortyProvider.characters().body()
       apiResponse?.results?.forEach(){
           val character = Character(it.id,it.name,it.status,it.species,it.type,it.gender,it.origin,it.location,it.image,it.episode, it.url,it.created)
           characters.add(character)
       }
        return characters
    }

    override fun getCharacter(id: Int): Character {
        return characters.first(){it.id == id.toLong() }
    }
}