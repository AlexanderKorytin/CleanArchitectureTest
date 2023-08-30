package com.example.myapplication.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModelFactory(this)).get(MainViewModel::class.java)

        Log.e("EEE", "Activity create")
        viewModel.resultSave.observe(this, Observer {
            bindingMain.textGet.text = it
        })

        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        bindingMain.buttonGet.setOnClickListener {
            viewModel.load()
        }

        bindingMain.buttonSave.setOnClickListener {
            hideKeyboard()
            viewModel.save(bindingMain.textSave.text.toString())
        }
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}