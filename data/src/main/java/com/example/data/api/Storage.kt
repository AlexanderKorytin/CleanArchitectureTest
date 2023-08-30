package com.example.data.api

import com.example.data.models.UserNameData

interface Storage {

    fun get(): UserNameData

    fun put(user: UserNameData)
}