package com.sobarna.basicprovapp.data.remote.retrofit

import com.sobarna.basicprovapp.data.remote.response.ProvResponse
import retrofit2.http.GET

interface ApiService {

    @GET("propinsi_api/provapi.php")
    suspend fun getDataProv(): ProvResponse
}