package com.example.hiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var btnSayHi: Button
    private lateinit var etYourName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Components
        btnSayHi = binding.btnSayHi
        etYourName = binding.etYourName

        //Events
        btnSayHi.setOnClickListener {
            getAnCheckName()
        }
    }

    private fun getAnCheckName() {
        val name = etYourName.text.toString()
        val intent = Intent(this, ResultActivity::class.java) //You send it to ResultActivity
        if(name.isNotEmpty()) {
            intent.putExtra("INTENT_NAME", name)
            startActivity(intent)
        }
        else {
            showErrorLog()
        }

    }

    private fun showErrorLog() {
        Toast.makeText(this, "Text is empty", Toast.LENGTH_LONG).show()
    }

}