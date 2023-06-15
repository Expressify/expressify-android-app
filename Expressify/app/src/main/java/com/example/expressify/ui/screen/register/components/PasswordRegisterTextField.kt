package com.example.expressify.ui.screen.register.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.expressify.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRegisterOutTextField(
    textValue: String,
    onValueChange: (String) -> Unit,
    onNext: (KeyboardActionScope.() -> Unit),
    modifier: Modifier = Modifier
) {
    var visibilityPassword by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            Text(text = stringResource(id = R.string.input_password))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Password,
                contentDescription = "Icon Password"
            )
        },
        trailingIcon = {
            val (icon, iconColor) = if (visibilityPassword) {
                Pair(
                    Icons.Filled.Visibility,
                    Color.Red.copy(0.7F)
                )
            } else {
                Pair(
                    Icons.Filled.VisibilityOff,
                    Color.DarkGray
                )
            }

            IconButton(onClick = { visibilityPassword = !visibilityPassword }) {
                Icon(
                    icon,
                    contentDescription = "Visibility",
                    tint = iconColor
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        visualTransformation = if (visibilityPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = onNext
        ),
        shape = RoundedCornerShape(16.dp)
    )
}