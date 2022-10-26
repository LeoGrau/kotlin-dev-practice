package com.example.sharedpreferences.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.sharedpreferences.R
import com.example.sharedpreferences.applications.UserVipApplication.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var tvWelcome: TextView
    private lateinit var clContainer: ConstraintLayout
    private lateinit var btnSignOut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)

        tvWelcome = binding.tvWelcome
        clContainer = binding.clCointainer
        btnSignOut = binding.btnSignOut

        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initUI()

        btnSignOut.setOnClickListener {
            signOut()
        }
    }

    private fun initUI() {
        setInfo()
    }

    private fun setInfo() {
        val nameSaved = prefs.getName()
        tvWelcome.text = resources.getString(R.string.welcome_text, nameSaved);
        val isVip = prefs.getVIP()
        if(isVip) {
            clContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
        }
    }

    private fun signOut() {
        prefs.clear()
        onBackPressed() //Funciona como flutter!
    }

}