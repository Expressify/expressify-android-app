package com.example.expressify.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.theme.ExpressifyTheme

@Composable
fun ProfileScreen(
    name: String,
    email: String,
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit
) {
    ProfileContent(
        name = name,
        email = email,
        onLogoutClick = onLogoutClick
    )
}

@Composable
fun ProfileContent(
    onLogoutClick: () -> Unit,
    name: String,
    email: String,
    modifier: Modifier = Modifier,
) {
   Column(
       modifier = modifier
           .fillMaxSize()
           .verticalScroll(rememberScrollState())
           .padding(vertical = 32.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       Text(
           modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
           text = name,
           style = MaterialTheme.typography.titleLarge
       )
       Text(
           modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
           text = email,
           style = MaterialTheme.typography.titleMedium
       )
       Button(
           modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
           onClick = onLogoutClick,
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.Red
           )
       ) {
           Icon(
               imageVector = Icons.Filled.Logout, 
               contentDescription = "Logout"
           )
           Text(
               text = stringResource(id = R.string.logout),
               style = MaterialTheme.typography.titleMedium
           )
       }
   }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ExpressifyTheme() {
        ProfileContent(
            name = "Gitan Sahl Tazakha Wijaya",
            email = "gitansahltw@gmail.com",
            onLogoutClick = {}
        )
    }
}