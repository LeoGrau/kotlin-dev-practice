package com.example.viewbindingsample.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.viewbindingsample.databinding.SuperheroItemBinding
import com.example.viewbindingsample.model.Superhero

class SuperheroViewHolder(view: View): RecyclerView.ViewHolder(view){

    private lateinit var binding: SuperheroItemBinding
    private lateinit var tvSuperheroName: TextView

    init {
        binding = SuperheroItemBinding.bind(view) //You pass the "superhero_item.xml"
        tvSuperheroName = binding.tvSuperheroName
    }

    fun render(superhero: Superhero) {
        tvSuperheroName.text = superhero.name
    }
}