package com.example.myapplication.domain.UseCase

import com.example.myapplication.domain.api.Repository
import com.example.myapplication.domain.models.UserParam

class GetUserNameUseCase(private val repositoryImpl: Repository) {
    fun execute(): UserParam {
        return UserParam(repositoryImpl.get().FirstName)
    }
}