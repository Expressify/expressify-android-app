package com.example.expressify.ui.screen.jurnal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.model.dummyJurnal
import com.example.expressify.ui.screen.components.Divider
import com.example.expressify.ui.screen.components.JurnalItem
import com.example.expressify.ui.screen.components.JurnalShortCut
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun JurnalScreen(
    modifier: Modifier = Modifier,
    tambahJurnal: () -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ){
        item{
            JurnalShortCut(
                title = stringResource(id = R.string.tambah_jurnal_title),
                onClick = tambahJurnal,
                modifier.padding(top = 8.dp)
            )
            Divider()
        }
        items(dummyJurnal, key = { it.id }) { jurnal ->
            JurnalItem(text = jurnal.text, date = jurnal.date, attention = jurnal.attention)
        }
    }
}

@Composable
fun ListJurnal(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(top = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyJurnal, key = { it.id }) { jurnal ->
            JurnalItem(text = jurnal.text, date = jurnal.date, attention = jurnal.attention)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JurnalScreenPreview() {
    ExpressifyTheme {
        JurnalScreen(
            tambahJurnal = {}
        )
    }
}