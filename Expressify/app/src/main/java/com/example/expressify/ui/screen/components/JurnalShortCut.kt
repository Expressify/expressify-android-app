package com.example.expressify.ui.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.expressify.R

@Composable
fun JurnalShortCut(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(bottom = 12.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.user_feelings),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(horizontal = 16.dp)
        )
        com.example.expressify.ui.screen.home.InputText()
        MaxWidthButton(
            text = stringResource(id = R.string.save_button_ph),
            modifier = modifier,
            onClick = onClick
        )
    }
}