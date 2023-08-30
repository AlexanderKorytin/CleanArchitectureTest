package com.example.myapplication.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.UseCase.GetUserNameUseCase
import com.example.domain.UseCase.SaveUserNameUseCase

class MainViewModel(private val useCaseGet: GetUserNameUseCase, private val useCaseSave: SaveUserNameUseCase): ViewModel() {

    var resultSave = MutableLiveData<String>()

    init {
        Log.e("EEE", "VM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("EEE", "VM destroyed")
    }

    fun save(text : String){
        if (text.isNotEmpty()){
        useCaseSave.execute(com.example.domain.models.UserParam(text))
        resultSave.value = "Name $text saved!"
        } else resultSave.value = "Entered name!!!"
    }

    fun load(){
        resultSave.value = useCaseGet.execute().FirstName
    }
}