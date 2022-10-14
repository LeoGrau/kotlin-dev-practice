package com.example.viewbindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingsample.adapter.SuperheroAdapter
import com.example.viewbindingsample.databinding.ActivityMainBinding
import com.example.viewbindingsample.provider.SuperheroProvider

class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityMainBinding

    //Components
    private lateinit var rvSuperhero: RecyclerView
    private lateinit var btnSeeFragment: Button
    private lateinit var btnSeeActivity: Button
    private lateinit var anyFragment: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding assignation
        binding = ActivityMainBinding.inflate(layoutInflater)

        //Components
        btnSeeActivity = binding.btnActivity
        btnSeeFragment = binding.btnFragment
        rvSuperhero = binding.rvSuperheroes
        anyFragment = binding.anyFragment

        //Draw content view
        setContentView(binding.root)

        initRecyclerView()
        anyFragment.visibility = View.GONE

        btnSeeActivity.setOnClickListener {
            showRecyclerView()
        }
        btnSeeFragment.setOnClickListener {
            showFragment()
        }

    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        rvSuperhero.layoutManager = layoutManager
        rvSuperhero.adapter = SuperheroAdapter(SuperheroProvider.superheroList)
    }

    private fun showFragment() {
        anyFragment.visibility = View.VISIBLE
        rvSuperhero.visibility = View.GONE
    }

    private fun showRecyclerView() {
        rvSuperhero.visibility = View.VISIBLE
        anyFragment.visibility = View.GONE
    }
}