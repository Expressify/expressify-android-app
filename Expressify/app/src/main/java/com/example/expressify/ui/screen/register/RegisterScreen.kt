package com.example.expressify.ui.screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.screen.components.BigButton
import com.example.expressify.ui.screen.components.InputText
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    RegisterContent(
        onLoginClick = onLoginClick
    )
}
@Composable
fun RegisterContent(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painterResource(id = R.drawable.logo_undertext),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .padding(bottom = 52.dp)
        )
        InputText(
            placeholder = stringResource(id = R.string.input_name),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 24.dp)
        )
        InputText(
            placeholder = stringResource(id = R.string.input_email),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 24.dp)
        )
        InputText(
            placeholder = stringResource(id = R.string.input_password),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 24.dp)
        )
        InputText(
            placeholder = stringResource(id = R.string.confirm_pass),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 36.dp)
        )
        BigButton(
            text = stringResource(id = R.string.register),
            onClick = {},
            modifier = Modifier
                .padding(start = 80.dp, end = 80.dp, bottom = 8.dp)
                .fillMaxWidth()
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Text(
                text = stringResource(id = R.string.already_have_acc),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { onLoginClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    ExpressifyTheme {
        RegisterContent(
            onLoginClick = {}
        )
    }
}