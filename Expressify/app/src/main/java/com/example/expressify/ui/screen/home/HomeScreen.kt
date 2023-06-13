package com.example.expressify.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expressify.R
import com.example.expressify.model.dummyArtikel
import com.example.expressify.ui.ViewModelFactory
import com.example.expressify.ui.screen.components.ArtikelItem
import com.example.expressify.ui.screen.components.Divider
import com.example.expressify.ui.screen.components.FlexWidthButton
import com.example.expressify.ui.screen.components.JurnalShortCut
import com.example.expressify.ui.screen.jurnal.JurnalViewModel
import com.example.expressify.ui.screen.login.components.ProgressBarLoading
import com.example.expressify.ui.theme.ExpressifyTheme
import com.example.expressify.ui.theme.FourthColor

@Composable
fun HomeScreen(
    onClick: () -> Unit,
    moveToJurnal: () -> Unit,
) {

    val viewModel: JurnalViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Banner()
        Spacer(modifier = Modifier.padding(4.dp))
        JurnalShortCut(
            title = stringResource(id = R.string.greet_user, viewModel.getName()),
            moveToJurnal = moveToJurnal
        )
        Divider()
        KeadaanMood(
            modifier = Modifier
                .align(CenterHorizontally),
            onClick = onClick
        )
        Divider()
        QuickListArtikel()

    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner_poster),
            contentDescription = "Banner Image 1",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Composable
fun QuickListArtikel(
    modifier: Modifier = Modifier,
) {
    Column {
        Text(
            text = stringResource(id = R.string.artikel_title),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp)
        )
        LazyRow(
            modifier = modifier.padding(8.dp)
        ) {
            items(dummyArtikel, key = { it.title }) { artikel ->
                ArtikelItem(artikel = artikel)
            }
        }
    }
}

@Composable
fun KeadaanMood(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.padding(vertical = 16.dp),
        colors = CardDefaults.cardColors(FourthColor),
    ) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(
                text = stringResource(id = R.string.knowingMood),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            Row(modifier = modifier) {
                Text(
                    text = stringResource(id = R.string.knowingMood_desc),
                    modifier = modifier
                        .width(200.dp)
                        .padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                FlexWidthButton(
                    text = stringResource(id = R.string.start_button_ph),
                    modifier = modifier,
                    onClick = onClick
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ExpressifyTheme {
//        HomeScreen()
    }
}