package com.example.app_pokemon.affichage.api

data class PokemonDetailsResponse(
    val name: String,
    val types: List<PokemonSlot>
)

data class PokemonSlot(
    val slot: Int,
            val type: PokemonType
)
        data class PokemonType(
val name: String,
val url:String
)