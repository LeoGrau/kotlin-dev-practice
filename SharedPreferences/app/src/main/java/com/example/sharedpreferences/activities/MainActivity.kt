package com.example.sharedpreferences.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.sharedpreferences.R
import com.example.sharedpreferences.applications.UserVipApplication.Companion.prefs //Interesante puedes importar solo los prefs con el companion object!
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var btnConfirm: Button
    private lateinit var etName: EditText;
    private lateinit var cbVip: CheckBox;


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        btnConfirm = binding.btnConfirm
        etName = binding.etName
        cbVip = binding.cbVip

        setContentView(binding.root);

        if(prefs.getName().isNotEmpty()) {
            goToDetail()
        }
        initUI()
    }

    fun initUI() {
        btnConfirm.setOnClickListener {
            accessToDetail()
        }
    }

    fun accessToDetail() {
        if (etName.text.toString().isNotEmpty()) {
            prefs.saveName("Leonardo")
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()
        } else {
            Toast.makeText(this, "There is no name", Toast.LENGTH_SHORT).show()
        }

    }

    fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }

}