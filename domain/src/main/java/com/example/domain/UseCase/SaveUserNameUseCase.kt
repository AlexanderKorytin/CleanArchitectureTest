package com.example.domain.UseCase

import com.example.domain.api.Repository
import com.example.domain.models.UserParam

class SaveUserNameUseCase(private val repositoryImpl: Repository) {
    fun execute(user: UserParam){
        repositoryImpl.put(user)
    }
}