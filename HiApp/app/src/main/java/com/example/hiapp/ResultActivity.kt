package com.example.hiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.hiapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityResultBinding

    //Components
    private lateinit var btnBack: Button
    private lateinit var tvCheers: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Components
        btnBack = binding.btnBack
        tvCheers = binding.tvCheers

        //Methods!
        getName()

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    fun getName() {
        val bundle = intent.extras //Package where you got intents
        val name = bundle?.get("INTENT_NAME")
        tvCheers.text = "Bienvenido $name"
    }
}