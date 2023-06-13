package com.example.expressify.ui.screen.jurnal

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expressify.data.UserRepository
import com.example.expressify.data.remote.request.JurnalRequest
import com.example.expressify.data.remote.response.Jurnals
import com.example.expressify.data.remote.response.ListJurnalResponse
import com.example.expressify.data.remote.response.PostJurnalResponse
import com.example.expressify.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JurnalViewModel (private val repository: UserRepository): ViewModel() {
    private val _journals = MutableLiveData<List<Jurnals>>()
    val journals: LiveData<List<Jurnals>> = _journals

    val progressBar = mutableStateOf(false)
    val error = mutableStateOf(false)
    val isSuccess = mutableStateOf(false)
    val perasaan = mutableStateOf("")

    private var token: String = ""
    private var id: String = ""
    private var name: String = ""


    init {
        getUser()
        fetchJournals()
    }

    private fun getUser(){
        viewModelScope.launch {
            repository.getUser().collect{
                token = it.token
                id = it.id
                name = it.name
            }
        }
    }

    fun getName(): String {
        getUser()
        return name
    }

    fun postJournals(jurnal: String){
        progressBar.value = true
        val client = ApiConfig.getApiService().postJurnal("Bearer $token" ,JurnalRequest(jurnal, id))
        client.enqueue(
            object: Callback<PostJurnalResponse>{
                override fun onResponse(
                    call: Call<PostJurnalResponse>,
                    response: Response<PostJurnalResponse>
                ) {
                    progressBar.value = false
                    isSuccess.value = response.isSuccessful && response.body()?.status == true
                    fetchJournals()
                    perasaan.value = ""
                }

                override fun onFailure(call: Call<PostJurnalResponse>, t: Throwable) {
                    progressBar.value = false
                    isSuccess.value = false
                }
            }
        )
    }

    fun fetchJournals() {
        progressBar.value = true

        Log.i("JurnalViewModel", "token: $token")
        Log.i("JurnalViewModel", "id: $id")

        val client = ApiConfig.getApiService().getAllJurnals("Bearer $token", id)
        client.enqueue(
            object:Callback<ListJurnalResponse>{
                override fun onResponse(
                    call: Call<ListJurnalResponse>,
                    response: Response<ListJurnalResponse>
                ) {
                    Log.i("JurnalViewModel", "Success")
                    progressBar.value = false
                    if (response.isSuccessful && response.body()?.status == true) {
                        response.body()?.let {
                            _journals.value = it.data as List<Jurnals>?
                        }
                    }
                }

                override fun onFailure(call: Call<ListJurnalResponse>, t: Throwable) {
                    Log.e("JurnalViewModel", "Failure")
                    progressBar.value = false
                    error.value = true
                }
            }
        )
    }
}