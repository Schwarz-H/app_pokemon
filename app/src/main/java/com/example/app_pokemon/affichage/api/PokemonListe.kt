package com.example.app_pokemon.affichage.api

import com.example.app_pokemon.affichage.liste.Pokemon

data class PokemonListe(
    val count: Int,
    val next: String,
    val results: List<Pokemon>

)