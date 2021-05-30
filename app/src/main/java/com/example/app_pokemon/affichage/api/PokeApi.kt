package com.example.app_pokemon.affichage.api

import retrofit2.Call
import retrofit2.http.GET

interface PokeApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonResponse>

}