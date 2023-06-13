package com.example.expressify.ui.screen.artikel

import androidx.camera.core.impl.CameraRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expressify.data.ArtikelRepository
import com.example.expressify.model.Artikel
import com.example.expressify.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailArtikelViewModel (
    private val repository: ArtikelRepository
        ): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Artikel>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Artikel>>
        get() = _uiState

    fun getArtikelById(artikelId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(
                repository.getArtikelById(
                    artikelId = artikelId
                )
            )
        }
    }
}