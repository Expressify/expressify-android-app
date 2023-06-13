package com.example.expressify.ui.screen.jurnal

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expressify.R
import com.example.expressify.ui.ViewModelFactory
import com.example.expressify.ui.screen.components.Divider
import com.example.expressify.ui.screen.components.JurnalItem
import com.example.expressify.ui.screen.components.JurnalShortCut
import com.example.expressify.ui.screen.login.components.ProgressBarLoading

@Composable
fun JurnalScreen(
    modifier: Modifier = Modifier,
    viewModel: JurnalViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    ),
) {

    val journals by viewModel.journals.observeAsState(emptyList())
    val progressBarVisible = viewModel.progressBar.value

    DisposableEffect(Unit) {
        viewModel.fetchJournals()
        onDispose { }
    }

    LazyColumn(
        modifier = modifier
    ) {
        item {
            JurnalShortCut(
                title = stringResource(id = R.string.tambah_jurnal_title),
                modifier.padding(top = 8.dp)
            )
            Divider()
            
            if (journals.isEmpty()) {
                Text(
                    text = "Jurnal masih kosong!",
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth().padding(top = 12.dp)
                )
            }
        }
        
        items(journals, key = { it.id }) { jurnal ->
            val att = jurnal.prediction?.equals("Terindikasi Mental Illness") == true
            JurnalItem(text = jurnal.jurnal, attention = att)
        }
    }

    ProgressBarLoading(isLoading = progressBarVisible)

}

//@Preview(showBackground = true)
//@Composable
//fun JurnalScreenPreview() {
//    ExpressifyTheme {
//        JurnalScreen(
//            tambahJurnal = {},
//
//        )
//    }
//}