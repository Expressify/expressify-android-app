package com.example.expressify.model

data class UserModel(
    val name: String,
    val token: String,
    val id: String,
    val email: String,
    val isLogin: Boolean
)
