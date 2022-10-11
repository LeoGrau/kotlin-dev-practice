package com.example.recycle_view_sample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view_sample.R
import com.example.recycle_view_sample.holder.SuperHeroViewHolder
import com.example.recycle_view_sample.model.SuperHero

//Esta clase se encarga de adaptar los datos de un provider al recycler view. Es decir, poner la informacion en el recycler view

class SuperHeroAdapter(private val superheroes: List<SuperHero>): RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder { //Lo que esta funcion hara es devolver el item que creamos (item_superhero) por cada objeto que haya de superheroe
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false)) //inflate devuelve un tipo View. Por eso, en el ViewHolder
        //Creo que el parent es lo que vemos en el layout.xml del item que creamos cuando posicionamos un objeto.
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) { //Va a pasar por cada uno de los items y va a llamar al superheroe render para pasarle los datos
        val item = superheroes[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = superheroes.size
}