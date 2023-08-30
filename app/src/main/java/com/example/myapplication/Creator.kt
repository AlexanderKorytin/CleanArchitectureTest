package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.data.impl.RepositoryImpl
import com.example.myapplication.data.impl.SharedPrefStorage
import com.example.myapplication.domain.UseCase.GetUserNameUseCase
import com.example.myapplication.domain.UseCase.SaveUserNameUseCase
import com.example.myapplication.domain.api.Repository
