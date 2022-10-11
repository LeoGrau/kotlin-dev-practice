package com.example.recycle_view_sample.holder

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view_sample.R
import com.example.recycle_view_sample.databinding.ItemSuperheroBinding
import com.example.recycle_view_sample.model.SuperHero
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

//El viewholder se encarga de "pintar" las celdas o dibujar los items del listado del recyclerview
class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: ItemSuperheroBinding
    private val tvSuperHero: TextView
    private val tvRealName: TextView
    private val tvPublisher: TextView
    private val ivSuperHero: ImageView

    init {
        binding = ItemSuperheroBinding.bind(view)
        tvSuperHero = binding.tvSuperHero
        tvRealName = binding.tvRealName
        tvPublisher = binding.tvPublisher
        ivSuperHero = binding.ivSuperHero
    }

    fun render(superHero: SuperHero) {
        tvSuperHero.text = superHero.superHeroeName
        tvRealName.text = superHero.realName
        tvPublisher.text = superHero.publisher

        val imageUrl = superHero.photoUrl
        Picasso.Builder(ivSuperHero.context)
            .build()
            .load(imageUrl)
            .into(ivSuperHero)

    }
}