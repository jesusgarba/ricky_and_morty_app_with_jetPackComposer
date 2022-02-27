package com.example.rickandmorty.data

import com.example.rickandmorty.data.model.Gender
import com.example.rickandmorty.data.model.Location
import com.example.rickandmorty.data.model.Species
import com.example.rickandmorty.data.model.Status

data class Character(
    val id: Long? = null,
    val name: String? = null,
    val status: Status? = null,
    val species: Species? = null,
    val type: String? = null,
    val gender: Gender? = null,
    val origin: Location? = null,
    val location: Location? = null,
    val image: String? = null,
    val episode: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)

data class Location (
    val name: String? = null,
    val url: String? = null
)

enum class Species {
    Alien,
    Human
}

enum class Status {
    Alive,
    Dead,
    Unknown
}

