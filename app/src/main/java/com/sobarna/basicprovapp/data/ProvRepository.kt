package com.sobarna.basicprovapp.data

import android.util.Log
import com.sobarna.basicprovapp.data.remote.retrofit.ApiService
import com.sobarna.basicprovapp.model.Provinsi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProvRepository private constructor(
    private val apiService: ApiService
) {
    fun getDataProv(): Flow<Result<List<Provinsi>>> = flow {
        emit(Result.Loading)
        try {
            val mapResponse = apiService.getDataProv().data?.map {
                Provinsi(
                    nik = it.nik ?: "",
                    nama = it.nama ?: "",
                    id = it.id ?: "",
                    idProv = it.idProv ?: "",
                    jumlahPenduduk = it.jumlahPenduduk ?: "",
                    idProp = it.idProp ?: "",
                    namaProp = it.namaProp ?: ""
                )
            } ?: emptyList()
            emit(Result.Success(mapResponse))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
            Log.d(javaClass.name, e.toString())
        }
    }

    companion object {
        @Volatile
        private var instance: ProvRepository? = null

        fun getInstance(
            apiService: ApiService
        ): ProvRepository =
            instance ?: synchronized(this) {
                instance ?: ProvRepository(apiService)
            }.also { instance = it }
    }
}