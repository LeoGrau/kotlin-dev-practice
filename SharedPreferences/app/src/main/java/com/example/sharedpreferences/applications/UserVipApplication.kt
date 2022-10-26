package com.example.sharedpreferences.applications

import android.annotation.SuppressLint
import android.app.Application


//La clase Application posee la variable para darnos el contexto general de la aplicacion
class UserVipApplication: Application() {

    companion object {
        lateinit var prefs: Preferences
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferences(applicationContext)
    }

}