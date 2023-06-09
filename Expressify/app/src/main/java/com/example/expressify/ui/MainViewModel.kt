package com.example.expressify.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expressify.data.UserRepository
import com.example.expressify.data.remote.request.LoginRequest
import com.example.expressify.data.remote.response.LoginResponse
import com.example.expressify.data.remote.retrofit.ApiConfig
import com.example.expressify.model.UserModel
import com.example.expressify.ui.common.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (private val repository: UserRepository): ViewModel() {

    val isLogin = mutableStateOf(false)
    val progressBar = mutableStateOf(false)
    val isSuccessLoading = mutableStateOf(false)
    val imageErrorAuth = mutableStateOf(false)

    init {
        getUser()
    }

    fun getUser() {
        viewModelScope.launch {
            repository.getUser()
                .catch {
                    isLogin.value = false
                }
                .collect{
                    isLogin.value = it.isLogin
                }
        }
    }

    fun login (email: String, password:String) {
        progressBar.value = true
        val client = ApiConfig.getApiService().login(LoginRequest(email, password))
        client.enqueue(
            object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    progressBar.value = false
                    if (response.isSuccessful && response.body()?.status == true) {
                        response.body()?.let {
                            val loginData = it.data
                            addLoginData(loginData.nama, loginData.email, loginData.id, loginData.accessToken)

                            isSuccessLoading.value = true

                            getUser()
                        }
                    } else {
                        imageErrorAuth.value = true
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    progressBar.value = false
                    imageErrorAuth.value = true
                }
            }
        )
    }

    private fun addLoginData(
        name: String,
        email: String,
        id: String,
        token: String
    ) {
        viewModelScope.launch {
            repository.login(name, email, id, token)
        }
    }
}