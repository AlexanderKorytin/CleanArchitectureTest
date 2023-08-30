package com.example.data.impl

import com.example.data.api.Storage
import com.example.data.models.UserNameData

class RepositoryImpl(val storage: Storage) : com.example.domain.api.Repository {
    override fun put(user: com.example.domain.models.UserParam) {
        storage.put(toStorage(user))
    }

    override fun get(): com.example.domain.models.UserParam {
        return toDomain(storage.get())
    }

    private fun toStorage(user: com.example.domain.models.UserParam): UserNameData {
        return UserNameData(user.FirstName)
    }

    private fun toDomain(user: UserNameData): com.example.domain.models.UserParam {
        return com.example.domain.models.UserParam(user.name)
    }
}