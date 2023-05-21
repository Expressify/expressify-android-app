package com.example.expressify.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.expressify.R

private val appFontFamily = FontFamily(
    fonts = listOf(
        Font(resId = R.font.open_sans_regular, weight = FontWeight.Normal, style = FontStyle.Normal),
        Font(resId = R.font.open_sans_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
        Font(resId = R.font.open_sans_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
        Font(resId = R.font.open_sans_light, weight = FontWeight.Light, style = FontStyle.Normal),
        Font(resId = R.font.open_sans_medium, weight = FontWeight.Medium, style = FontStyle.Normal)
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val expressifyTypography = Typography(
    bodyLarge = Typography.bodyLarge.copy(fontFamily = appFontFamily),
    bodyMedium = Typography.bodyMedium.copy(fontFamily = appFontFamily),
    bodySmall = Typography.bodySmall.copy(fontFamily = appFontFamily),
    headlineLarge = Typography.headlineLarge.copy(fontFamily = appFontFamily),
    headlineMedium = Typography.headlineMedium.copy(fontFamily = appFontFamily),
    headlineSmall = Typography.headlineSmall.copy(fontFamily = appFontFamily),
    labelLarge = Typography.labelLarge.copy(fontFamily = appFontFamily),
    labelMedium = Typography.labelMedium.copy(fontFamily = appFontFamily),
    labelSmall = Typography.labelSmall.copy(fontFamily = appFontFamily),
    titleLarge = Typography.titleLarge.copy(fontFamily = appFontFamily),
    titleMedium = Typography.titleMedium.copy(fontFamily = appFontFamily),
    titleSmall = Typography.titleSmall.copy(fontFamily = appFontFamily)
)