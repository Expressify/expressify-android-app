package com.example.expressify.ui.home

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun HomeScreen() {
    Text(text = "Hello world", style = MaterialTheme.typography.labelSmall)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ExpressifyTheme {
        HomeScreen()
    }
}