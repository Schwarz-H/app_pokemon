package com.example.app_pokemon.affichage.EcranDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.app_pokemon.R
import com.example.app_pokemon.affichage.Singleton
import com.example.app_pokemon.affichage.api.PokemonDetailsResponse
import com.example.app_pokemon.affichage.api.PokemonListe
import com.example.app_pokemon.databinding.FragmentDetailBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Detail : Fragment() {
private lateinit var textViewName: TextView
    private var _binding: FragmentDetailBinding? = null



    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    textViewName = view.findViewById((R.id.pokemon_details_name))
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("pokemonId") ?:-1

        Singleton.pokeApi.getdetail(id).enqueue(object : Callback<PokemonDetailsResponse>{

         fun onFailure(call: Call<PokemonListe>, t: Throwable) {

        }

         override fun onResponse(
            call: Call<PokemonDetailsResponse>,
            response: Response<PokemonDetailsResponse>)
        {
         if (response.isSuccessful && response.body() != null) {

                textViewName.text = response.body()!!.name
    }

    }
    })

}
}