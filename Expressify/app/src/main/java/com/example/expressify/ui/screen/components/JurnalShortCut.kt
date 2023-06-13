package com.example.expressify.ui.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expressify.R
import com.example.expressify.ui.ViewModelFactory
import com.example.expressify.ui.screen.jurnal.JurnalViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun JurnalShortCut(
    title: String,
    modifier: Modifier = Modifier,
    moveToJurnal: () -> Unit = {},
) {

    val viewModel: JurnalViewModel = viewModel(
        factory = ViewModelFactory(LocalContext.current)
    )

    val perasaan by viewModel.perasaan
    val keyboardController = LocalSoftwareKeyboardController.current

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
        InputText(
            onValueChange = { newInput -> viewModel.perasaan.value = newInput},
            value = perasaan,)
        MaxWidthButton(
            text = stringResource(id = R.string.save_button_ph),
            modifier = modifier,
            onClick = {
                viewModel.postJournals(perasaan)
                keyboardController?.hide()
                moveToJurnal()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String = "",
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }),
        placeholder = {
            Text(
                text = stringResource(id = R.string.input_text_feeling_ph)
            )
        },
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(16.dp)
            )
    )
}