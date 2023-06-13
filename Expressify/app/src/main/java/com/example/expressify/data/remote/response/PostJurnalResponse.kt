package com.example.expressify.data.remote.response

import com.google.gson.annotations.SerializedName

data class PostJurnalResponse(

	@field:SerializedName("data")
	val data: Jurnal? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class Jurnal(

	@field:SerializedName("jurnal")
	val jurnal: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("prediction")
	val prediction: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
