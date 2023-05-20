package com.example.expressify.ui.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expressify.R
import com.example.expressify.ui.theme.ExpressifyTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navigateNext: () -> Unit,
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alpha = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000)
        navigateNext()
    }
    Splash(alpha = alpha.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo_banner_transparant),
            contentDescription = "Logo Icon",
            modifier = Modifier
                .size(250.dp)
                .alpha(alpha)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ExpressifyTheme {
        SplashScreen(navigateNext = {})
    }
}