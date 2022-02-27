package com.example.rickandmorty.data.model

/*class ApiResponse {
    val status: String? = null
    val code: String? = null
    val characters: List<Character>? =null*/


    data class ApiResponse(
        val info: Info? = null,
        val results: List<Result>? = null
    )

    data class Info(
        val count: Long? = null,
        val pages: Long? = null,
        val next: String? = null,
        val prev: Any? = null
    )

    data class Result(
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

    enum class Gender {
        Female,
        Male,
        Unknown
    }

    data class Location(
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

//}