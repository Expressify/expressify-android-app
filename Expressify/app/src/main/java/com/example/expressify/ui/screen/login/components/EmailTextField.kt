package com.example.expressify.ui.screen.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.theme.ExpressifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailOutTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    onClear: () -> Unit,
    onNext: (KeyboardActionScope.() -> Unit),
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            Text(text = stringResource(id = R.string.input_email))
        },
        trailingIcon = {
            if (textValue.isNotEmpty()) {
                IconButton(onClick = onClear) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Icon Clear"
                    )
                }
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Icon Email"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = onNext
        ),
        shape = RoundedCornerShape(16.dp)
    )
}

@Preview
@Composable
fun EmptyEmailTextFieldPreview() {
    ExpressifyTheme() {
        EmailOutTextField(
            textValue = "",
            onValueChange = {},
            onClear = { /*TODO*/ },
            onNext = {}
        )
    }
}

@Preview
@Composable
fun FilledEmailTextFieldPreview() {
    ExpressifyTheme() {
        EmailOutTextField(
            textValue = "gitansahltw@gmail.com",
            onValueChange = {},
            onClear = { /*TODO*/ },
            onNext = {}
        )
    }
}