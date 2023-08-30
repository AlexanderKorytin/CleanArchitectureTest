package com.example.domain.UseCase

import com.example.domain.api.Repository
import com.example.domain.models.UserParam

class GetUserNameUseCase(private val repositoryImpl: Repository) {
    fun execute(): UserParam {
        return UserParam(repositoryImpl.get().FirstName)
    }
}