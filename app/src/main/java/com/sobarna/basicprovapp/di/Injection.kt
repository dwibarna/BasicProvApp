package com.sobarna.basicprovapp.di

import com.sobarna.basicprovapp.data.ProvRepository
import com.sobarna.basicprovapp.data.remote.retrofit.ApiConfig

object Injection {
    fun provideRepository(): ProvRepository =
        ProvRepository.getInstance(ApiConfig.getApiService())
}