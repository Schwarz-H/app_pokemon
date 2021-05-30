package com.example.app_pokemon.affichage.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("pokemon")
    fun getPokemonList(): Call<PokemonListe>
    @GET("pokemon/{id}")
    fun getdetail(@Path(value = "id") id: String): Call<PokemonListe>
}