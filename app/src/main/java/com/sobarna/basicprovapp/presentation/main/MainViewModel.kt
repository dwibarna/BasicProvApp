package com.sobarna.basicprovapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sobarna.basicprovapp.data.ProvRepository

class MainViewModel(repository: ProvRepository) : ViewModel() {

    val getDataProv = repository.getDataProv().asLiveData()
}
