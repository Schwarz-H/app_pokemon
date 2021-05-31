package com.example.app_pokemon.affichage

import com.example.app_pokemon.affichage.api.PokeApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singleton {
    companion object {

        var cache: Cache = Cache(File(context.getCacheDir(), "responses"), 10 * 1024 * 1024) // 10Mib
        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .build()

             val pokeApi: PokeApi = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                 .client(okhttpClient)
                .build()
                .create(PokeApi::class.java)


        }
    }
