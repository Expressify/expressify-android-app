package com.example.expressify.ui.screen.register

import android.util.Log
import android.util.Patterns
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expressify.R
import com.example.expressify.ui.ViewModelFactory
import com.example.expressify.ui.screen.components.BigButton
import com.example.expressify.ui.screen.login.components.EmailOutTextField
import com.example.expressify.ui.screen.register.components.BookGenreContent
import com.example.expressify.ui.screen.register.components.ConfirmPasswordOutTextField
import com.example.expressify.ui.screen.register.components.FilmGenreContent
import com.example.expressify.ui.screen.register.components.MusicGenreContent
import com.example.expressify.ui.screen.register.components.NameOutTextField
import com.example.expressify.ui.screen.register.components.PasswordRegisterOutTextField

@Composable
fun RegisterScreen(
    onLoginClick: () -> Unit,
    onRegister: (String, String, String, List<String>) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = viewModel(
    factory = ViewModelFactory(LocalContext.current)
)
) {
    val musicGenre by viewModel.musicGenreList.observeAsState(initial = emptyList())
    val filmGenre by viewModel.filmGenreList.observeAsState(initial = emptyList())
    val bookGenre by viewModel.bookGenreList.observeAsState(initial = emptyList())

    when (viewModel.page.value) {
        0 -> {
            RegisterContent(
                name = viewModel.name.value,
                email = viewModel.email.value,
                password = viewModel.password.value,
                confirmPassword = viewModel.confirmPassword.value,
                onNameChange = { name ->
                    viewModel.name.value = name
                },
                onEmailChange = { email ->
                    viewModel.email.value = email
                },
                onPasswordChange = { pass ->
                    viewModel.password.value = pass
                },
                onConfirmPasswordChange = { confPass ->
                    viewModel.confirmPassword.value = confPass
                },
                onEmailClear = { viewModel.email.value = "" },
                onNameClear = { viewModel.name.value = "" },
                onLoginClick = onLoginClick,
                onNext = {
                    viewModel.page.value += 1
                }
            )
        }
        1 -> {
            MusicGenreContent(
                listGenre = musicGenre,
                onGenreClick = {
                    viewModel.musicGenreClicked(it)
                },
                onNext = { viewModel.page.value += 1},
                onPrev = { viewModel.page.value -= 1},
                count = viewModel.musicGenreCount.value
            )
        }
        2 -> {
            FilmGenreContent(
                listGenre = filmGenre,
                onGenreClick = {
                    viewModel.filmGenreClicked(it)
                },
                onNext = { viewModel.page.value += 1 },
                onPrev = { viewModel.page.value -= 1 },
                count = viewModel.filmGenreCount.value
            )
        }
        3 -> {
            BookGenreContent(
                listGenre = bookGenre,
                onGenreClick = {
                    viewModel.bookGenreClicked(it)
                },
                onNext = { onRegister(viewModel.name.value, viewModel.email.value, viewModel.password.value, viewModel.getSelectedGenres()) },
                onPrev = { viewModel.page.value -= 1 },
                count = viewModel.bookGenreCount.value,
                isLoading = isLoading
            )
        }
    }
}


@Composable
fun RegisterContent(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onEmailClear: () -> Unit,
    onNameClear: () -> Unit,
    onLoginClick: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier
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
            modifier = Modifier
                .padding(bottom = 52.dp)
        )
        NameOutTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 18.dp),
            textValue = name,
            onValueChange = onNameChange,
            onClear = onNameClear,
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
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
        PasswordRegisterOutTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 18.dp),
            textValue = password,
            onValueChange = onPasswordChange,
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        )
        ConfirmPasswordOutTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 44.dp, end = 44.dp, bottom = 36.dp),
            textValue = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            onDone = { focusManager.clearFocus() }
        )
        BigButton(
            text = stringResource(id = R.string.next),
            onClick = onNext,
            modifier = Modifier
                .padding(start = 80.dp, end = 80.dp, bottom = 8.dp)
                .fillMaxWidth(),
            enabled = isValid(name, email, password, confirmPassword)
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

private fun isValid(name: String, email: String, password: String, confirmPassword: String):Boolean {
    if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) return false
    if (password != confirmPassword) return false
    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return false
    return true
}