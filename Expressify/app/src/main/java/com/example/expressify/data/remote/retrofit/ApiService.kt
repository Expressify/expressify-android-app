package com.example.expressify.data.remote.retrofit

import com.example.expressify.data.remote.request.JurnalRequest
import com.example.expressify.data.remote.request.LoginRequest
import com.example.expressify.data.remote.response.ListJurnalResponse
import com.example.expressify.data.remote.response.LoginResponse
import com.example.expressify.data.remote.response.PostJurnalResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("api/v1/auth/login")
    fun login(
        @Body loginRequest: LoginRequest
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
}