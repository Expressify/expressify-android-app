package com.example.expressify.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expressify.data.UserRepository
import com.example.expressify.data.remote.request.LoginRequest
import com.example.expressify.data.remote.request.RegisterRequest
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

class MainViewModel (private val repository: UserRepository, private val context: Context): ViewModel() {

    val isLogin = mutableStateOf(false)
    val progressBar = mutableStateOf(false)
    val isSuccessLoading = mutableStateOf(false)
    val imageErrorAuth = mutableStateOf(false)
    val email = mutableStateOf("")
    val name = mutableStateOf("")

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
                    email.value = it.email
                    name.value = it.name
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
                        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                        response.body()?.let {
                            val loginData = it.data
                            addLoginData(loginData.nama, loginData.email, loginData.id, loginData.accessToken)

                            isSuccessLoading.value = true

                            getUser()
                        }
                    } else {
                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    progressBar.value = false
                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    fun register(name: String, email: String, password: String, genreList: List<String>) {
        progressBar.value = true
        val registerRequest = RegisterRequest(nama = name, email = email, password = password, genre = genreList)
        val client = ApiConfig.getApiService().register(registerRequest)
        client.enqueue(
            object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    progressBar.value = false
                    if (response.isSuccessful && response.body() != null) {
                        Toast.makeText(context, "Register Success", Toast.LENGTH_SHORT).show()
                        response.body()?.let {
                            val loginData = it.data
                            addLoginData(loginData.nama, loginData.email, loginData.id, loginData.accessToken)
                            Log.d("Register", "onSuccessResponse")

                            isSuccessLoading.value = true

                            getUser()
                        }
                    } else {
                        response.body()?.let {
                            Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    progressBar.value = false
                    Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
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

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
        getUser()
        isLogin.value = false
    }
}