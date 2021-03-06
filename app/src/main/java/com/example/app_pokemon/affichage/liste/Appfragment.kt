package com.example.app_pokemon.affichage.liste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_pokemon.R
import com.example.app_pokemon.affichage.Singleton
import com.example.app_pokemon.affichage.api.PokemonListe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

            val list = getListFromCache()
        if(list.isEmpty()){
            callApi()
        }else {
        showList(list)

        }
        
    }

    private fun getListFromCache(): List<Pokemon> {
        //TODO

    }


    private fun saveListIntoCache() {
        TODO("Not yet implemented")
    }

    private fun callApi() {
        Singleton.pokeApi.getPokemonList().enqueue(object : Callback<PokemonListe> {

            override fun onFailure(call: Call<PokemonListe>, t: Throwable) {
                TODO("Not yet implemented")
            }



            override fun onResponse(
                call: Call<PokemonListe>,
                response: Response<PokemonListe>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val pokemonResponse = response.body()!!
                    saveListIntoCache()
                    showList(pokemonResponse.results)
                }


            }


        })
    }



    private fun showList(PokemonList: List <Pokemon>) {
        adapter.updateList(PokemonList)

    }

    private fun onClickedPokemon(id: Int) {

            findNavController().navigate(R.id.NavigationVersLeDetail, bundleOf(
                "pokemonId" to (id +1)
            ))


    }
}