package com.example.retrofitapiconsume.holder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapiconsume.databinding.DogItemBinding
import com.example.retrofitapiconsume.model.Dog

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding: DogItemBinding

    private lateinit var ivDogPicture: ImageView

    fun renderItem(dog: Dog) {

    }
}