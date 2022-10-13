package com.example.recycle_view_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycle_view_sample.adapter.SuperHeroAdapter
import com.example.recycle_view_sample.databinding.ActivityMainBinding
import com.example.recycle_view_sample.model.SuperHero
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

        //There are 2 types LinearLayoutManager and GridLayoutManager
        //Linear (Flex similarity)
        val manager = LinearLayoutManager(this) //1st: Create manager
        //Grid
        val managerGrid = GridLayoutManager(this, 2)

        //2nd: Create decoration with manager
        val decoration = DividerItemDecoration(this, manager.orientation) //flex
        val decorationGrid = DividerItemDecoration(this, managerGrid.orientation)  //grid

        //3rd: Add layout manager(with this you got the visualization, but with the itemDecoration you draw that gray line)
        rvSuperHero.layoutManager = manager //Enable this to turn on flex or LinearLayoutManager, but disable the other one
        //rvSuperHero.layoutManager = managerGrid //Enable this to turn on grid or GridLayoutManager, but disable the other one

        rvSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superheros) { superhero -> //Lambdas go out! but you can continue adding methods.
            onItemSelected(
                superhero
            )
        }
        tvSuperHeroSize.text = SuperHeroAdapter(SuperHeroProvider.superheros) { superHero -> onItemSelected(superHero) } .itemCount.toString()

        //3rd: You add the ItemDecoration
        //rvSuperHero.addItemDecoration(decorationGrid) //Enable this to turn on grid or GridLayoutManager, but disable the other one
        rvSuperHero.addItemDecoration(decoration) //Enable this to turn on flex or LinearLayoutManager, but disable the other one
    }


    private fun onItemSelected(superhero: SuperHero) {
        Toast.makeText(this, superhero.superHeroeName, Toast.LENGTH_LONG).show()
    }
}