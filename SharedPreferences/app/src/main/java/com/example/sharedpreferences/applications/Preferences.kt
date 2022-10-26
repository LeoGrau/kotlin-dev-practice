package com.example.sharedpreferences.applications

import android.annotation.SuppressLint
import android.content.Context

class Preferences(val context: Context) {

    //Name of database for shared preferences
    val SHARED_NAME = "MyDataBase"

    //Name of values!
    val SHARED_USER_NAME = "username"
    val SHARED_VIP = "vip"

    //The database for shared preferences
    val storage = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    fun saveName(name: String) {
        val editor = storage.edit()
        editor.putString(SHARED_USER_NAME, name).apply() //storage.edit().putString(SHARED_USER_NAME, name)
        editor.commit()
    }

    @SuppressLint("CommitPrefEdits")
    fun saveVIP(vip:Boolean) {
        val editor = storage.edit()
        editor.putBoolean(SHARED_VIP, vip).apply()
        editor.commit()
    }

    fun getName():String {
        return storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getVIP(): Boolean {
        return storage.getBoolean(SHARED_VIP, false)
    }

    @SuppressLint("CommitPrefEdits")
    fun clear() {
        storage.edit().clear().apply()
    }

}