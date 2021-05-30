package com.example.app_pokemon.affichage.liste

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_pokemon.R
import kotlinx.coroutines.channels.consumesAll

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class app_fragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = app_adapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_liste,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.app_recyclerview)


        recyclerView.apply {
            layoutManager = layoutManager
            adapter = adapter
        }


    }


}