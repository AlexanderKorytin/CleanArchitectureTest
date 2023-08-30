package com.example.myapplication.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val repository by lazy {
        com.example.data.impl.RepositoryImpl(
            com.example.data.impl.SharedPrefStorage(context)
        )
    }
    private val useCaseSave by lazy { com.example.domain.UseCase.SaveUserNameUseCase(repository) }
    private val useCaseGet by lazy { com.example.domain.UseCase.GetUserNameUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  MainViewModel(useCaseGet = useCaseGet, useCaseSave = useCaseSave) as T
    }
}