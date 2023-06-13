package com.example.expressify.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListJurnalResponse(

	@field:SerializedName("data")
	val data: List<Jurnals?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class Jurnals(

	@field:SerializedName("jurnal")
	val jurnal: String,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("prediction")
	val prediction: Any? = null,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("created_at")
	val date: String,
)
