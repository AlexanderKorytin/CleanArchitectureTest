package com.example.myapplication.data.impl

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.myapplication.data.api.Storage
import com.example.myapplication.data.models.UserNameData
private const val USER_DATA_FILE = "User_data_file"
private const val USER_DATA_POINT = "User_Point"
private const val DEFAULT_NAME = "No_data"

class SharedPrefStorage(private val context: Context): Storage {
    val sharedPref = context.getSharedPreferences(USER_DATA_FILE, MODE_PRIVATE)
    override fun get(): UserNameData {
        return UserNameData(sharedPref?.getString(USER_DATA_POINT, DEFAULT_NAME)?: DEFAULT_NAME)
    }

    override fun put(user: UserNameData) {
        sharedPref.edit().putString(USER_DATA_POINT, user.name).apply()
    }

}