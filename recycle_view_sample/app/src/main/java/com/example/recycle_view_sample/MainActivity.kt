package com.example.recycle_view_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view_sample.adapter.SuperHeroAdapter
import com.example.recycle_view_sample.databinding.ActivityMainBinding
import com.example.recycle_view_sample.provider.SuperHeroProvider

class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvSuperHero: RecyclerView
    private lateinit var tvSuperHeroSize: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        rvSuperHero = binding.rvSuperHero
        tvSuperHeroSize = binding.tvSuperHeroSize

        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvSuperHero.layoutManager = LinearLayoutManager(this)
        rvSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superheros)
        tvSuperHeroSize.text = SuperHeroAdapter(SuperHeroProvider.superheros).itemCount.toString()
    }
}