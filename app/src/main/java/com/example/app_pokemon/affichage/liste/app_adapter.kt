package com.example.app_pokemon.affichage.liste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_pokemon.R
import kotlin.reflect.KFunction1

class app_adapter(private var dataSet: List<Pokemon>, var listener: KFunction1<Int, Unit> = null) :
        RecyclerView.Adapter<app_adapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView

            init {
                // Define click listener for the ViewHolder's View.
                textView = view.findViewById(R.id.nom_pokemon)
            }
        }

        fun updateList(list: List<Pokemon>){
            dataSet = list
            notifyDataSetChanged()

        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.app_item, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            val pokemon :Pokemon = dataSet[position]
            viewHolder.textView.text = pokemon.nom
            viewHolder.itemView.setOnClickListener{
                listener?.invoke(pokemon)
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }

