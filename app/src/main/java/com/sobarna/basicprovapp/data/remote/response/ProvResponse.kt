package com.sobarna.basicprovapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ProvResponse(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItem(

	@field:SerializedName("nik")
	val nik: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("id_prop")
	val idProp: String? = null,

	@field:SerializedName("jumlah_penduduk")
	val jumlahPenduduk: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("Id_prop")
	val idProv: String? = null,

	@field:SerializedName("nama_prop")
	val namaProp: String? = null
)
