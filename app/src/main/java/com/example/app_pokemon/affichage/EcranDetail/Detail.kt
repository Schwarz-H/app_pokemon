package com.example.app_pokemon.affichage.EcranDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app_pokemon.R
import com.example.app_pokemon.affichage.Singleton
import com.example.app_pokemon.affichage.api.PokemonDetailsResponse
import com.example.app_pokemon.databinding.FragmentDetailBinding
import javax.security.auth.callback.Callback


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Detail : Fragment() {

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

        callApi()
    }

    private fun callApi() {
        Singleton.pokeApi.getdetail("1").enqueue(object: Callback<PokemonDetailsResponse>)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}