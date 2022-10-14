package com.example.viewbindingsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingsample.R
import com.example.viewbindingsample.holder.SuperheroViewHolder
import com.example.viewbindingsample.model.Superhero

class SuperheroAdapter(private val superheroesList: List<Superhero>): RecyclerView.Adapter<SuperheroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context) //Important!
        return SuperheroViewHolder(layoutInflater.inflate(R.layout.superhero_item, parent, false))
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superheroItem = superheroesList[position]
        holder.render(superheroItem)
    }

    override fun getItemCount(): Int = superheroesList.size

}