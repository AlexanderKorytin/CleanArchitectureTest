package com.example.myapplication.presentation

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.impl.RepositoryImpl
import com.example.myapplication.data.impl.SharedPrefStorage
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.UseCase.GetUserNameUseCase
import com.example.myapplication.domain.UseCase.SaveUserNameUseCase
import com.example.myapplication.domain.models.UserParam

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val storage =  SharedPrefStorage(context = applicationContext)
        val repository = RepositoryImpl(storage)
        val useCaseSave = SaveUserNameUseCase(repository)
        val useCaseGet = GetUserNameUseCase(repository)
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        bindingMain.buttonGet.setOnClickListener {
            bindingMain.textGet.text = useCaseGet.execute().FirstName
        }

        bindingMain.buttonSave.setOnClickListener {
            hideKeyboard()
            useCaseSave.execute(UserParam(bindingMain.textSave.text.toString()))
        }
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}