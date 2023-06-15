package com.example.expressify.data.remote.retrofit

import com.example.expressify.data.remote.request.JurnalRequest
import com.example.expressify.data.remote.request.LoginRequest
import com.example.expressify.data.remote.request.RegisterRequest
import com.example.expressify.data.remote.response.AllGenreResponse
import com.example.expressify.data.remote.response.ListJurnalResponse
import com.example.expressify.data.remote.response.LoginResponse
import com.example.expressify.data.remote.response.MoodPredictionResponse
import com.example.expressify.data.remote.response.PostJurnalResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {

    @POST("api/v1/auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>

    @POST("api/v1/auth/register")
    fun register(
        @Body registerRequest: RegisterRequest
    ): Call<LoginResponse>

    @GET("api/v1/users/{id}/user_jurnals")
    fun getAllJurnals(
        @Header("Authorization") auth: String,
        @Path("id") id: String
    ): Call<ListJurnalResponse>

    @POST("api/v1/user_jurnals")
    fun postJurnal(
        @Header("Authorization") auth: String,
        @Body jurnalRequest: JurnalRequest
    ): Call<PostJurnalResponse>

    @Multipart
    @POST("api/v1/user_prediction_transactions")
    fun getPrediction(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("user_id") user_id: RequestBody
    ): Call<MoodPredictionResponse>

    @GET("api/v1/genres")
    fun getGenre():Call<AllGenreResponse>
}