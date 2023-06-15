package com.example.expressify.ui.screen.login

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.screen.components.BigButton
import com.example.expressify.ui.screen.components.InputText
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.example.expressify.ui.screen.login.components.EmailOutTextField
import com.example.expressify.ui.screen.login.components.PasswordOutTextField
import com.example.expressify.ui.screen.login.components.ProgressBarLoading
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: (email: String, password: String) -> Unit,
    onRegisterClick: () -> Unit,
    loadingProgressBar: Boolean
) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    LoginContent(
        email = email,
        password = password,
        onLoginClick = { onLoginClick(email, password) },
        onRegisterClick = onRegisterClick,
        loadingProgressBar = loadingProgressBar,
        onEmailChange = {
            email = it
        },
        onPasswordChange = {
            password = it
        },
        onEmailClear = { email = "" }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    email: String,
    password: String,
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    loadingProgressBar: Boolean,
    onEmailClear: () -> Unit,
) {
    val focusManager = LocalFocusManager.current

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
            modifier = Modifier.padding(bottom = 52.dp)
        )
        EmailOutTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 18.dp),
            textValue = email,
            onValueChange = onEmailChange,
            onClear = onEmailClear,
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
        PasswordOutTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 36.dp),
            textValue = password,
            onValueChange = onPasswordChange,
            onDone = { focusManager.clearFocus() }
        )
        BigButton(
            text = stringResource(id = R.string.login),
            onClick = onLoginClick,
            modifier = Modifier
                .padding(start = 80.dp, end = 80.dp, bottom = 8.dp)
                .fillMaxWidth(),
            enabled = email.isNotEmpty() && password.isNotEmpty()
        )
        Row (
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Text(
                text = stringResource(id = R.string.didnt_have_acc),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(id = R.string.create_acc),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { onRegisterClick() }
            )
        }
    }

    ProgressBarLoading(isLoading = loadingProgressBar)
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ExpressifyTheme() {
        LoginContent(
            email = "gitansahltw@gmail.com",
            password = "gitansahl",
            onLoginClick = { /*TODO*/ },
            onRegisterClick = { /*TODO*/ },
            onEmailChange = {},
            loadingProgressBar = true,
            onEmailClear = {},
            onPasswordChange = {}
        )
    }
}