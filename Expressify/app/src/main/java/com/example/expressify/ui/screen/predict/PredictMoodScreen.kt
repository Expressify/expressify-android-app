package com.example.expressify.ui.screen.predict

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.expressify.R
import com.example.expressify.data.remote.response.RecommendationData
import com.example.expressify.ui.ViewModelFactory
import com.example.expressify.ui.screen.components.BigButton
import com.example.expressify.ui.screen.login.components.ProgressBarLoading
import com.example.expressify.ui.screen.predict.components.EmotionCard
import com.example.expressify.ui.theme.ExpressifyTheme
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun PredictMoodScreen(
    navigateBack: () -> Unit,
    uri: String,
    viewModel: PredictMoodViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    )
) {

    val context = LocalContext.current
    if (!viewModel.isRequested.value) {
        viewModel.getRecommendation(
            Uri.parse(URLDecoder.decode(uri, StandardCharsets.UTF_8.toString())),
            context
        )
    }
    Log.d("PredictMoodScreen", "ImageUri: $uri")

    PredictMoodContent(
        uri = Uri.parse(uri),
        navigateBack = navigateBack,
        isLoading = viewModel.isLoading.value,
        emotion = viewModel.mood.value,
        recommendationData = viewModel.recommendationData.value,
        onRecommendationClick = {
            redirectToRecommendation(context, it)
        },
        isError = viewModel.isError.value
    )
}

@Composable
fun PredictMoodContent(
    uri: Uri,
    navigateBack: () -> Unit,
    isLoading: Boolean,
    emotion: String,
    modifier: Modifier = Modifier,
    recommendationData: RecommendationData?,
    onRecommendationClick: (String) -> Unit,
    isError: Boolean
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            rememberImagePainter(uri),
            contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .heightIn(min = 200.dp)
        )
        Text(
            text = stringResource(id = R.string.moodify_result),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 4.dp)
        )
        Divider(
            modifier.padding(horizontal = 32.dp)
        )
        Box(modifier = Modifier.padding(top = 16.dp)) {
            ProgressBarLoading(isLoading = isLoading)
            if (!isLoading && !isError) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.mood),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        EmotionCard(
                            modifier = Modifier.padding(start = 8.dp),
                            emotion = emotion
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.recommendation),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    if (recommendationData != null) {
                        Button(
                            onClick = { onRecommendationClick(recommendationData.url) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            ),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .size(width = 200.dp, height = 48.dp)
                        ) {
                            Text(
                                text = recommendationData.judul,
                                style = MaterialTheme.typography.bodyMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    } else {
                        Text(
                            text = stringResource(id = R.string.not_rec),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                }
            } else if (isError) {
                Text(
                    text = stringResource(id = R.string.error_pred),
                    modifier = Modifier.padding(top = 32.dp, start = 32.dp, end = 32.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Button(
            onClick = navigateBack,
            modifier = Modifier
                .padding(32.dp)
                .heightIn(min = 48.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = stringResource(id = R.string.back),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

private fun redirectToRecommendation(context: Context, uri: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun MoodifyPrediction() {
    ExpressifyTheme() {
        PredictMoodContent(
            uri = Uri.parse("https://assets.vogue.in/photos/640592409d03d0d41504f3a0/master/pass/Face%20taping%20.jpg"),
            navigateBack = {  },
            isLoading = false,
            emotion = "Sad",
            recommendationData = null,
            onRecommendationClick = {},
            isError = true
        )
    }
}