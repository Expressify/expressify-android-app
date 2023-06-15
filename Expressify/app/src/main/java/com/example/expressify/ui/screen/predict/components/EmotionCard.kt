package com.example.expressify.ui.screen.predict.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun EmotionCard(
    emotion: String,
    modifier: Modifier = Modifier,
) {
    val (backgroundColor, mainColor) = when (emotion) {
        "Happy" -> Pair(Color(0xFFD5FCD9), Color(0xFF009F10))
        "Disgust" -> Pair(Color(0xFFFABFFF), Color(0xFFB90DF6))
        "Fear" -> Pair(Color(0xFFFFEDBF), Color(0xFFF66F0D))
        "Angry" -> Pair(Color(0xFFFFBFBF), Color(0xFFF60D0D))
        "Sad" -> Pair(Color(0xFFBFE0FF), Color(0xFF0D94F6))
        "Surprise" -> Pair(Color(0xFFFFFCBF), Color.Black)
        else -> Pair(Color.White, Color.Black)
    }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(0.1.dp, mainColor),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Text(
            text = emotion,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            style = MaterialTheme.typography.bodySmall,
            color = mainColor,
            fontSize = 15.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmotionCardPreview() {
    ExpressifyTheme {
        EmotionCard(
            emotion = "Surprise",
        )
    }
}