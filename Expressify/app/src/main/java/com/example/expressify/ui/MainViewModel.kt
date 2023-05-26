package com.example.expressify.ui

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expressify.data.UserRepository
import com.example.expressify.model.UserModel
import com.example.expressify.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel (private val repository: UserRepository): ViewModel() {

    private val _loginState: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(UiState.Loading)
    val loginState: StateFlow<UiState<Boolean>> = _loginState

    init {
        getUser()
    }

    fun getUser() {
        viewModelScope.launch {
            repository.getUser()
                .catch {
                    _loginState.value = UiState.Error(it.message.toString())
                }
                .collect{
                    _loginState.value = UiState.Success(it.isLogin)
                }
        }
    }

    fun login() {
        _loginState.value = UiState.Loading
        viewModelScope.launch {
            repository.login()
        }
    }
}