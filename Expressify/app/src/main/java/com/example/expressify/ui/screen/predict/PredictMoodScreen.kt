package com.example.expressify.ui.screen.predict

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import coil.compose.rememberImagePainter

@Composable
fun PredictMoodScreen(
    navigateBack: () -> Unit,
    uri: String,
    viewModel: PredictMoodViewModel
) {


    PredictMoodContent(
        uri = Uri.parse(uri),
        navigateBack = navigateBack,
        isLoading = viewModel.isLoading.value
    )
}

@Composable
fun PredictMoodContent(
    uri: Uri,
    navigateBack: () -> Unit,
    isLoading: Boolean
) {
    Image(
        painter = rememberImagePainter(uri),
        contentDescription = null
    )
}