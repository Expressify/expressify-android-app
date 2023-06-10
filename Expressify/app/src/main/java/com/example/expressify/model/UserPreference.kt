package com.example.expressify.model

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>){
    fun getUser(): Flow<UserModel> {
        return dataStore.data.map { pref ->
            UserModel(
                pref[NAME_KEY] ?: "",
                pref[TOKEN_KEY] ?: "",
                pref[ID_KEY] ?: "",
                pref[EMAIL_KEY] ?: "",
                pref[STATE_KEY] ?: false
            )
        }
    }

    suspend fun login(
        name: String,
        email: String,
        id: String,
        token: String
    ) {
        dataStore.edit { pref ->
            pref[NAME_KEY] = name
            pref[EMAIL_KEY] = email
            pref[ID_KEY] = id
            pref[TOKEN_KEY] = token
            pref[STATE_KEY] = true
        }
    }

    suspend fun logout() {
        dataStore.edit { pref ->
            pref[STATE_KEY] = false
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val NAME_KEY = stringPreferencesKey("name")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val ID_KEY = stringPreferencesKey("id")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val STATE_KEY = booleanPreferencesKey("state")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}