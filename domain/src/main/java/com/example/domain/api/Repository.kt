package com.example.domain.api

import com.example.domain.models.UserParam

interface Repository {

    fun put(user: UserParam)

    fun get(): UserParam
}