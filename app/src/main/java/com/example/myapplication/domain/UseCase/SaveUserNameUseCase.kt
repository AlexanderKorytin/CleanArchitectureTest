package com.example.myapplication.domain.UseCase

import com.example.myapplication.domain.api.Repository
import com.example.myapplication.domain.models.UserParam

class SaveUserNameUseCase(private val repositoryImpl: Repository) {
    fun execute(user: UserParam){
        repositoryImpl.put(user)
    }
}