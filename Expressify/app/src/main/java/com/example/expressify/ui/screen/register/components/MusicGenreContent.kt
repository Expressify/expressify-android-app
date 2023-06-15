package com.example.expressify.ui.screen.register.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expressify.R
import com.example.expressify.ui.screen.components.BigButton
import com.example.expressify.ui.screen.login.components.ProgressBarLoading
import com.example.expressify.ui.screen.register.GenreModel
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun MusicGenreContent(
    listGenre: List<GenreModel>,
    onGenreClick: (String) -> Unit,
    onNext: () -> Unit,
    onPrev: () -> Unit,
    count: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(rememberScrollState()),
    ) {
        IconButton(
            onClick = onPrev,
            modifier = Modifier.padding(start = 24.dp, top = 24.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
        }
        Text(
            text = stringResource(id = R.string.halo),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(top = 32.dp, start = 24.dp)
        )
        Text(
            text = stringResource(id = R.string.what_music),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, start = 24.dp)
        )
        if (listGenre.isEmpty()) {
            ProgressBarLoading(
                modifier = Modifier.padding(top = 60.dp),
                isLoading = true
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(100.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(vertical = 32.dp, horizontal = 32.dp)
                    .heightIn(max = 400.dp)
            ) {
                items(listGenre) {
                    GenreBox(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 48.dp),
                        picked = it.picked,
                        name = it.namaGenre.capitalize(),
                        onClick = { onGenreClick(it.id) }
                    )
                }
            }
            BigButton(
                text = stringResource(id = R.string.next),
                onClick = onNext,
                modifier = Modifier
                    .padding(start = 80.dp, end = 80.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                enabled = count > 0
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MusicGenrePreview() {
    ExpressifyTheme() {
        MusicGenreContent(
            listGenre = listGenre,
            onGenreClick = {},
            onNext = { },
            onPrev = {},
            count = 0
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MusicGenreEmptyPreview() {
    ExpressifyTheme() {
        MusicGenreContent(
            listGenre = emptyList(),
            onGenreClick = {},
            onNext = { },
            onPrev = {},
            count = 0
        )
    }
}

val listGenre = listOf<GenreModel>(
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
    GenreModel("", "GunadarmaMargonda", 0),
)