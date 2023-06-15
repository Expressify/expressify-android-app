package com.example.expressify.ui.screen.artikel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.expressify.R
import com.example.expressify.model.Artikel
import com.example.expressify.ui.ViewModelFactory
import com.example.expressify.ui.common.UiState
import com.example.expressify.ui.screen.components.LoadingScreen

@Composable
fun DetailScreen(
    artikelId: Long,
    navigateBack: () -> Unit,
    viewModel: DetailArtikelViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    )
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                LoadingScreen()
                viewModel.getArtikelById(artikelId)
            }

            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    artikel = data,
                    onBackClick = navigateBack,
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    artikel: Artikel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primary)
            ) {
                Row(modifier = modifier.padding(16.dp)) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.Black,
                        contentDescription = "back",
                        modifier = Modifier
                            .clickable { onBackClick() })
                    Text(
                        text = "Detail",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = Color.Black,
                        modifier = modifier.fillMaxWidth()
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                AsyncImage(
                    model = artikel.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp)
                        .height(200.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = artikel.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(8.dp)
                )
                Text(
                    text = stringResource(id =R.string.tanggal_artikel, artikel.date),
                    style = MaterialTheme.typography.labelLarge,
                    fontStyle = FontStyle.Italic,
                    modifier = modifier.padding(8.dp)
                )

                Text(
                    text = artikel.fullContent,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                    modifier = modifier.padding(8.dp)
                )
            }
        }
    }
}