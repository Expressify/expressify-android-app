package com.example.expressify.di

import android.content.Context
import com.example.expressify.data.UserRepository
import com.example.expressify.dataStore
import com.example.expressify.model.UserPreference

object Injection {

    fun provideUserRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository(pref)
    }
}