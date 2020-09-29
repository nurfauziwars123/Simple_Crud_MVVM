package com.example.submission6.model.getdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

	@field:SerializedName("mahasiswa_alamat")
	val alamat: String? = null,

	@field:SerializedName("mahasiswa_nohp")
	val nohp: String? = null,

	@field:SerializedName("id_mahasiswa")
	val id: String? = null,

	@field:SerializedName("mahasiswa_nama")
	val nama: String? = null
) : Parcelable