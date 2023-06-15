package com.example.expressify.data.remote.request

data class RegisterRequest(
    val nama: String,
    val email: String,
    val password: String,
    val genre: List<String>
)