package com.example.app_pokemon.affichage.api

data class PokemonDetailsResponse(
    val types: List<PokemonSlot>
)

data class PokemonSlot(
    val slot: Int,
            val type: PokemonType
){
        val type2: PokemonType? = null
}
        data class PokemonType(
val name: String,
val url:String
)