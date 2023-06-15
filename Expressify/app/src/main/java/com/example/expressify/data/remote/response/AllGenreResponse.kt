package com.example.expressify.data.remote.response

import com.google.gson.annotations.SerializedName

data class AllGenreResponse(

	@field:SerializedName("data")
	val data: DataGenre,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Boolean
)

data class DataGenre(

	@field:SerializedName("music")
	val music: List<MusicItem>,

	@field:SerializedName("book")
	val book: List<BookItem>,

	@field:SerializedName("film")
	val film: List<FilmItem>
)

data class MusicItem(

	@field:SerializedName("jenis_genre")
	val jenisGenre: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("nama_genre")
	val namaGenre: String
)

data class BookItem(

	@field:SerializedName("jenis_genre")
	val jenisGenre: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("nama_genre")
	val namaGenre: String
)

data class FilmItem(

	@field:SerializedName("jenis_genre")
	val jenisGenre: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("nama_genre")
	val namaGenre: String
)
