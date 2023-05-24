package com.example.expressify.ui.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.theme.ExpressifyTheme
import com.example.expressify.ui.theme.GreenSuccess
import com.example.expressify.ui.theme.YellowDanger

@Composable
fun JurnalItem(
    modifier: Modifier = Modifier,
    text: String,
    date: String,
    attention: Boolean = false
) {
    Card(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Row {
                Text(
                    text = date,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                if (attention) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        tint = YellowDanger,
                        contentDescription = null,
//                        modifier = Modifier.padding(end = 4.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        tint = GreenSuccess,
                        contentDescription = null,
//                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
            }
            if (attention) {
                Text(
                    text = stringResource(id = R.string.status_jurnal_attention),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = YellowDanger
                )
            } else {
                Text(
                    text = stringResource(id = R.string.status_jurnal_success),
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = GreenSuccess
                )
            }
            Text(
                text = text,
                style = MaterialTheme.typography.bodySmall,
                modifier = modifier
                    .padding(top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun JurnalItemPreview() {
    ExpressifyTheme {
        JurnalItem(attention = true, text = stringResource(id = R.string.lorem_ipsum), date = "12 Mei 2023")
    }
}