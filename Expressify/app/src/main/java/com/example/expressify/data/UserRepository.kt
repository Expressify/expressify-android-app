package com.example.expressify.data

import com.example.expressify.model.UserModel
import com.example.expressify.model.UserPreference
import kotlinx.coroutines.flow.Flow

class UserRepository (private val pref: UserPreference) {

    fun getUser(): Flow<UserModel> {
        return pref.getUser()
    }

    suspend fun login() {
        pref.login()
    }

    suspend fun logout() {
        pref.logout()
    }
}