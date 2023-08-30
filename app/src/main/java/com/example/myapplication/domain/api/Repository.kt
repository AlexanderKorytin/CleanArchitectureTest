package com.example.myapplication.domain.api

import com.example.myapplication.domain.models.UserParam

interface Repository {

    fun put(user: UserParam)

    fun get(): UserParam
}