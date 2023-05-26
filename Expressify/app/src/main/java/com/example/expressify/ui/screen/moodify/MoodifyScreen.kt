package com.example.expressify.ui.screen.moodify

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.screen.components.BigButton
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun MoodifyScreen() {
    MoodifyContent()
}
@Composable
fun MoodifyContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_only), 
            contentDescription = stringResource(id = R.string.menu_moodify)
        )
        Text(
            text = stringResource(id = R.string.menu_moodify),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.moodify_jargon),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 40.dp)
        )
        Text(
            text = stringResource(id = R.string.moodify_desc),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 64.dp, end = 64.dp, bottom = 32.dp)
        )
        Row (
            modifier = Modifier
                .padding(horizontal = 52.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            BigButton(
                modifier = Modifier
                    .weight(1f),
                text = stringResource(id = R.string.camera),
                onClick = { /*TODO*/ })
            BigButton(
                modifier = Modifier
                    .weight(1f),
                text = stringResource(id = R.string.gallery),
                onClick = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoodifyScreenPreview() {
    ExpressifyTheme {
        MoodifyContent()
    }
}