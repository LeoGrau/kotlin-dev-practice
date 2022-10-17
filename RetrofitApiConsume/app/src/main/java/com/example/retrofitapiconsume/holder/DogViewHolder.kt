package com.example.retrofitapiconsume.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapiconsume.databinding.DogItemBinding
import com.example.retrofitapiconsume.model.Dog
import com.squareup.picasso.Picasso

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding: DogItemBinding

    private lateinit var ivDogPicture: ImageView
    private lateinit var tvDogText: TextView

    init {
        //Binding always starts with Binding Object
        binding = DogItemBinding.bind(itemView)
        //Components
        ivDogPicture = binding.ivDogPicture
        tvDogText = binding.tvDogText

    }

    fun renderItem(dog: Dog) {
        renderImage(dog.photoUrl, ivDogPicture)
    }

    private fun renderImage(imageUrl: String, imageView: ImageView) {
        Picasso.Builder(ivDogPicture.context)
            .build()
            .load(imageUrl)
            .into(ivDogPicture)
    }
}