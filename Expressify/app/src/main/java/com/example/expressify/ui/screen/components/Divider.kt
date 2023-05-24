package com.example.expressify.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.expressify.ui.theme.GraySix

@Composable
fun Divider(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(GraySix)
    )
}