package com.example.expressify.ui.screen.artikel

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.expressify.R
import com.example.expressify.model.Artikel
import com.example.expressify.model.dummyArtikel
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun ArtikelScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    LazyColumn {
        item {
            Text(
                text = stringResource(id = R.string.artikel_title),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(vertical = 8.dp)
            )
        }

        items(dummyArtikel, key = { it.title }) { artikel ->
            ArtikelComponentItem(artikel = artikel, modifier = modifier.clickable(onClick = { navigateToDetail(artikel.id)}))
        }
    }
}

@Composable
fun ArtikelComponentItem(
    modifier: Modifier = Modifier,
    artikel: Artikel
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = artikel.image,
                contentDescription = "artikel image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
            )
            Text(
                text = artikel.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            )
            Text(
                text = artikel.content,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Justify,
                modifier = modifier
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = artikel.date,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 8.sp,
                textAlign = TextAlign.End,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}


@Preview
@Composable
fun ArtikelComponentItemPreview() {
    ExpressifyTheme {
        ArtikelComponentItem(artikel = dummyArtikel[0])
    }
}