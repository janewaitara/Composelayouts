package com.mumbicodes.composelayouts.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mumbicodes.composelayouts.R

private val Helvetica = FontFamily(
    Font(R.font.helvetica_neue_light, FontWeight.Light),
    Font(R.font.helvetica_neue_medium, FontWeight.Medium),
    Font(R.font.helvetica_neue_bold, FontWeight.Bold),
)
private val spotifyText = FontFamily(
    Font(R.font.circular_spotify_text_light, FontWeight.Light),
    Font(R.font.circular_spotify_text_medium, FontWeight.Medium),
    Font(R.font.circular_spotify_text_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = spotifyText,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = spotifyText,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = spotifyText,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    //Smallest text
    labelSmall = TextStyle(
        fontFamily = spotifyText,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 12.sp,
    )
)