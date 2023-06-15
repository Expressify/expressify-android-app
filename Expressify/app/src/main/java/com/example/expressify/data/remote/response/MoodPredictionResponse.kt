package com.example.expressify.data.remote.response

import com.google.gson.annotations.SerializedName

data class MoodPredictionResponse(

	@field:SerializedName("data")
	val data: PredictData,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean
)

data class CreatedData(

	@field:SerializedName("user_id")
	val userId: String,

	@field:SerializedName("url_photo")
	val urlPhoto: String,

	@field:SerializedName("prediction")
	val prediction: String,

	@field:SerializedName("recommendation")
	val recommendation: String,

	@field:SerializedName("id")
	val id: String
)

data class RecommendationData(

	@field:SerializedName("tipe")
	val tipe: String,

	@field:SerializedName("judul")
	val judul: String,

	@field:SerializedName("url")
	val url: String
)

data class PredictData(

	@field:SerializedName("createdData")
	val createdData: CreatedData,

	@field:SerializedName("recommendationData")
	val recommendationData: RecommendationData?
)
