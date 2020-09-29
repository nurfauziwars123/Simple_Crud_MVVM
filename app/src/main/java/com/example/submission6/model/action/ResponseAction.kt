package com.example.submission6.model.action

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseAction(

	@field:SerializedName("issSuccess")
	val issSuccess: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable