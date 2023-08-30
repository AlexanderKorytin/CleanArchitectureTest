package com.example.myapplication.data.api

import android.content.Context
import com.example.myapplication.data.models.UserNameData

interface Storage {

    fun get():UserNameData

    fun put(user: UserNameData)
}