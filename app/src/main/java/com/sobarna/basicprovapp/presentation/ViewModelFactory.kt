package com.sobarna.basicprovapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sobarna.basicprovapp.data.ProvRepository
import com.sobarna.basicprovapp.di.Injection
import com.sobarna.basicprovapp.presentation.main.MainViewModel

class ViewModelFactory private constructor(
    private val repository: ProvRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(repository) as T
        else
            throw java.lang.IllegalArgumentException("Unknown ViewModel Class: +${modelClass.name}")
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }.also { instance = it }
    }

}