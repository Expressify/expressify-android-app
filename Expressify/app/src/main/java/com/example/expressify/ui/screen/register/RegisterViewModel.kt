package com.example.expressify.ui.screen.register

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
import com.example.expressify.data.remote.response.AllGenreResponse
import com.example.expressify.data.remote.response.LoginResponse
import com.example.expressify.data.remote.retrofit.ApiConfig
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(private val repository: UserRepository): ViewModel() {
    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")
    val page = mutableStateOf(0)

    val musicGenreCount = mutableStateOf(0)
    val filmGenreCount = mutableStateOf(0)
    val bookGenreCount = mutableStateOf(0)

    private val _musicGenreList = MutableLiveData<List<GenreModel>>()
    val musicGenreList: LiveData<List<GenreModel>> = _musicGenreList

    private val _filmGenreList = MutableLiveData<List<GenreModel>>()
    val filmGenreList: LiveData<List<GenreModel>> = _filmGenreList

    private val _bookGenreList = MutableLiveData<List<GenreModel>>()
    val bookGenreList: LiveData<List<GenreModel>> = _bookGenreList

    init {
        getGenres()
    }

    fun getSelectedGenres(): List<String> {
        val res = mutableListOf<String>()
        _musicGenreList.value?.forEach {
            if (it.picked) res.add(it.id)
        }
        _filmGenreList.value?.forEach {
            if (it.picked) res.add(it.id)
        }
        _bookGenreList.value?.forEach {
            if (it.picked) res.add(it.id)
        }
        return res
    }

    private fun getGenres() {
        val client = ApiConfig.getApiService().getGenre()
        client.enqueue(object : Callback<AllGenreResponse> {
            override fun onResponse(
                call: Call<AllGenreResponse>,
                response: Response<AllGenreResponse>
            ) {
                if (response.body() != null && response.body()?.status == true) {
                    response.body()?.let {
                        _bookGenreList.value = it.data.book.map { book ->
                            GenreModel(book.id, book.namaGenre, book.jenisGenre)
                        }
                        _filmGenreList.value = it.data.film.map { film ->
                            GenreModel(film.id, film.namaGenre, film.jenisGenre)
                        }
                        _musicGenreList.value = it.data.music.map { music ->
                            GenreModel(music.id, music.namaGenre, music.jenisGenre)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<AllGenreResponse>, t: Throwable) {

            }
        })
    }

    fun filmGenreClicked(id: String) {
        _filmGenreList.value?.let {
            val index: Int = it.indexOfFirst { genre ->
                genre.id == id
            }
            val genreModel: GenreModel = it[index]
            if (genreModel.picked) filmGenreCount.value -= 1 else filmGenreCount.value += 1
            genreModel.picked = !genreModel.picked
            _filmGenreList.value = _filmGenreList.value?.toMutableList()?.apply {
                set(index, genreModel)
            }
        }
    }

    fun bookGenreClicked(id: String) {
        _bookGenreList.value?.let {
            val index: Int = it.indexOfFirst { genre ->
                genre.id == id
            }
            val genreModel: GenreModel = it[index]
            if (genreModel.picked) bookGenreCount.value -= 1 else bookGenreCount.value += 1
            genreModel.picked = !genreModel.picked
            _bookGenreList.value = _bookGenreList.value?.toMutableList()?.apply {
                set(index, genreModel)
            }
        }
    }

    fun musicGenreClicked(id: String) {
        _musicGenreList.value?.let {
            val index: Int = it.indexOfFirst { genre ->
                genre.id == id
            }
            val genreModel: GenreModel = it[index]
            if (genreModel.picked) musicGenreCount.value -= 1 else musicGenreCount.value += 1
            genreModel.picked = !genreModel.picked
            _musicGenreList.value = _musicGenreList.value?.toMutableList()?.apply {
                set(index, genreModel)
            }
        }

        Log.d("RegisterViewModel", "${_musicGenreList.value}")
    }
}

data class GenreModel(
    val id: String,
    val namaGenre: String,
    val jenisGenre: Int,
    var picked: Boolean = false
)