package com.example.expressify.ui.screen.components

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun MaxWidthButton(
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Black),
        enabled = enabled,
        modifier = modifier
            .fillMaxWidth()
            .height(38.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun MaxWidthButton() {
    ExpressifyTheme {
        MaxWidthButton(
            text = "Coba yah",
            modifier = Modifier,
            onClick = {}
        )
    }
}

@Composable
fun FlexWidthButton(
    text: String,
    modifier: Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Black),
        enabled = enabled,
        modifier = modifier
            .height(38.dp)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun FlexWidthButton() {
    ExpressifyTheme {
        FlexWidthButton(
            text = "Coba yah",
            modifier = Modifier,
            onClick = {}
        )
    }
}

@Composable
fun BigButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            Color.Black
        ),
        enabled = enabled,
        modifier = modifier
            .height(48.dp),

    ) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun BigButtonPreview() {
    ExpressifyTheme() {
        BigButton(
            text = "Example",
            onClick = {})
    }
}