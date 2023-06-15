package com.example.expressify.ui.screen.register.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun GenreBox(
    picked: Boolean,
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var color by rememberSaveable { mutableStateOf(picked) }
    Button(
        modifier = modifier,
        onClick = {
            color = !color
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (color) Color.Gray else Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(
            text = name,
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenreBoxPreview() {
    ExpressifyTheme() {
        GenreBox(
            picked = false,
            name = "Comedy",
            onClick = {}
        )
    }
}

