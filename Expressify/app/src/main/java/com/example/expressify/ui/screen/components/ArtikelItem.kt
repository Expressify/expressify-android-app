package com.example.expressify.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.expressify.R
import com.example.expressify.model.Artikel
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun ArtikelItem(
    modifier: Modifier = Modifier,
    artikel: Artikel,
) {
    Card(
        modifier = modifier
            .height(100.dp)
            .width(200.dp)
            .padding(start = 8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Row(modifier = modifier.fillMaxWidth()) {

            AsyncImage(
                model = artikel.image,
                contentDescription = artikel.title,
                contentScale = ContentScale.Crop,
                modifier = modifier.width(60.dp)
            )

            Column(
                modifier = modifier
                    .weight(1f)
                    .align(CenterVertically)
            ) {
                Text(
                    text = artikel.title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 10.sp,
                    lineHeight = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(4.dp)
                )
                Text(
                    text = artikel.date,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 8.sp,
                    textAlign = TextAlign.End,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtikelItemView() {
    ExpressifyTheme {
        ArtikelItem(
            artikel = Artikel(
                1,
                "https://static.vecteezy.com/system/resources/previews/006/792/345/original/mental-health-blooming-human-brain-line-icon-mind-concept-love-life-new-page-illustration-free-vector.jpg",
                "Judul Artikel",
                "12 Mei 2023",
                "Lorem ipsum", "none"
            )
        )

    }
}