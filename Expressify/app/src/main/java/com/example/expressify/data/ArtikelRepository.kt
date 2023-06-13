package com.example.expressify.data

import com.example.expressify.model.Artikel
import com.example.expressify.model.dummyArtikel

class ArtikelRepository {
    private val artikel = mutableListOf<Artikel>()

    init {
        if (artikel.isEmpty()) {
            dummyArtikel.forEach {
                artikel.add(it)
            }
        }
    }

    fun getArtikelById(artikelId: Long): Artikel {
        return artikel.first {
            it.id == artikelId
        }
    }
}