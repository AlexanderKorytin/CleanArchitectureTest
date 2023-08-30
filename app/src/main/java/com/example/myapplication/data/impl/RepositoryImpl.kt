package com.example.myapplication.data.impl

import com.example.myapplication.data.api.Storage
import com.example.myapplication.data.models.UserNameData
import com.example.myapplication.domain.api.Repository
import com.example.myapplication.domain.models.UserParam

class RepositoryImpl(val storage: Storage) : Repository {
    override fun put(user: UserParam) {
        storage.put(toStorage(user))
    }

    override fun get(): UserParam {
        return toDomain(storage.get())
    }

    private fun toStorage(user: UserParam): UserNameData {
        return UserNameData(user.FirstName)
    }

    private fun toDomain(user: UserNameData): UserParam {
        return UserParam(user.name)
    }
}