package com.example.retrofitapiconsume

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapiconsume.adapter.DogAdapter
import com.example.retrofitapiconsume.databinding.ActivityMainBinding
import com.example.retrofitapiconsume.model.Dog
import com.example.retrofitapiconsume.service.DogApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var rvDogs: RecyclerView
    private lateinit var svDog: SearchView
    private lateinit var tvDog: TextView

    private val dogs: MutableList<Dog> = mutableListOf()

    private lateinit var dogAdapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        rvDogs = binding.rvDogs
        svDog = binding.svDog
        tvDog = binding.tvTitle


        setContentView(binding.root)

        svDog.setOnQueryTextListener(this)

        initRecycleView()
    }

    private fun initRecycleView() {
        dogAdapter = DogAdapter(dogs)
        rvDogs.layoutManager = LinearLayoutManager(this)
        rvDogs.adapter = dogAdapter
    }

    private fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun searchByBreed(name: String) {

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = getRetrofit()
            val call = retrofit.create(DogApiService::class.java).getDogByBreed("$name/images")
            Log.i("Call", "$call")
            val responseDogs = call.body()



            runOnUiThread {
                if(call.isSuccessful) {
                    val dogsPhotoUrls = responseDogs?.photoUrls ?: emptyList() //Es como un operador ternario, si esta vacio, entonces se le asigna emptyList()
                    dogs.clear()
                    Log.i("MESSAGE", "$dogsPhotoUrls.size")
                    val maybeDogs: MutableList<Dog> = mutableListOf()
                    for(dogsPhotoUrl in dogsPhotoUrls) {
                        maybeDogs.add(Dog(dogsPhotoUrl))
                    }

                    dogs.addAll(maybeDogs)
                    dogAdapter.notifyDataSetChanged()
                    tvDog.text = dogAdapter.itemCount.toString()
                }
                else {
                    showError()
                }
            }
        }

    }

    private fun showError() {
        Toast.makeText(this, "Error",Toast.LENGTH_LONG).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()) {
            searchByBreed(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


}