package com.example.retrofitapiconsume.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.retrofitapiconsume.R
import com.example.retrofitapiconsume.holder.DogViewHolder
import com.example.retrofitapiconsume.model.Dog

class DogAdapter(private val DogList: List<Dog>): RecyclerView.Adapter<DogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder { //Bind the inflater with the correct item.
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.dog_item, parent, false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogItem: Dog = DogList[position]
        holder.renderItem(dogItem)
    }

    override fun getItemCount(): Int = DogList.size
}