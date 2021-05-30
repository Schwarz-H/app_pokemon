package com.example.app_pokemon.affichage.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_pokemon.R
import com.example.app_pokemon.affichage.api.PokeApi
import com.example.app_pokemon.affichage.api.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Appfragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = app_adapter(listOf(), ::onClickedPokemon)


    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_liste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.app_recyclerview)




        recyclerView.apply {
            layoutManager = this@Appfragment.layoutManager
            adapter = this@Appfragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi: PokeApi = retrofit.create(PokeApi::class.java)

        pokeApi.getPokemonList().enqueue(object : Callback<PokemonResponse> {

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    adapter.updateList(pokemonResponse.results)
                }


            }


        })
    }
        private fun onClickedPokemon(pokemon: Pokemon) {
            findNavController().navigate(R.id.NavigationVersLeDetail)


    }
}