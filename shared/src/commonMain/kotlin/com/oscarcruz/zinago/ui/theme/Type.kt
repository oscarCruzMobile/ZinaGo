package com.oscarcruz.zinago.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import zinago.shared.generated.resources.Res
import zinago.shared.generated.resources.urbanist_bold
import zinago.shared.generated.resources.urbanist_medium
import zinago.shared.generated.resources.urbanist_regular
import zinago.shared.generated.resources.urbanist_semi_bold


@Composable
fun urbanistFamily() = FontFamily(
    Font(Res.font.urbanist_regular,  FontWeight.Normal),
    Font(Res.font.urbanist_medium,   FontWeight.Medium),
    Font(Res.font.urbanist_semi_bold, FontWeight.SemiBold),
    Font(Res.font.urbanist_bold,     FontWeight.Bold),
)

@Composable
fun aspenTypography(): Typography {
    val urbanist = urbanistFamily()
    return Typography(
        displayLarge   = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Bold,     fontSize = 57.sp, lineHeight = 64.sp),
        displayMedium  = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Bold,     fontSize = 45.sp, lineHeight = 52.sp),
        displaySmall   = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Bold,     fontSize = 36.sp, lineHeight = 44.sp),
        headlineLarge  = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.SemiBold, fontSize = 32.sp, lineHeight = 40.sp),
        headlineMedium = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.SemiBold, fontSize = 28.sp, lineHeight = 36.sp),
        headlineSmall  = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp),
        titleLarge     = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 28.sp),
        titleMedium    = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Medium,   fontSize = 16.sp, lineHeight = 24.sp),
        titleSmall     = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Medium,   fontSize = 14.sp, lineHeight = 20.sp),
        bodyLarge      = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Normal,   fontSize = 16.sp, lineHeight = 24.sp),
        bodyMedium     = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Normal,   fontSize = 14.sp, lineHeight = 20.sp),
        bodySmall      = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Normal,   fontSize = 12.sp, lineHeight = 16.sp),
        labelLarge     = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Medium,   fontSize = 14.sp, lineHeight = 20.sp),
        labelMedium    = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Medium,   fontSize = 12.sp, lineHeight = 16.sp),
        labelSmall     = TextStyle(fontFamily = urbanist, fontWeight = FontWeight.Medium,   fontSize = 11.sp, lineHeight = 16.sp),
    )
}