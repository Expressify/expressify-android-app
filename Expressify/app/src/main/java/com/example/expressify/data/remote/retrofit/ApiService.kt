package com.example.expressify.data.remote.retrofit

import com.example.expressify.data.remote.request.LoginRequest
import com.example.expressify.data.remote.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/v1/auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>
}