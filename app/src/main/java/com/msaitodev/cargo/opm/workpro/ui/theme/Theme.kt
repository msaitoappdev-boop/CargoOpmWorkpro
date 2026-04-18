package com.msaitodev.cargo.opm.workpro.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.msaitodev.core.common.ui.LocalAppColors
import com.msaitodev.core.common.ui.AppColors

private val LightColorScheme = lightColorScheme(
    primary = BrandPrimary,
    secondary = BrandSecondary,
    tertiary = BrandTertiary,
    background = AppBackground,
    surface = AppBackground,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1B5E20), // 濃い緑の文字
    onSurface = Color(0xFF1B5E20),
)

private val DarkColorScheme = darkColorScheme(
    primary = BrandPrimaryDark,
    secondary = BrandSecondaryDark,
    tertiary = BrandTertiaryDark,
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    onPrimary = Color(0xFF00390A), // 濃い緑の文字
    onSecondary = Color(0xFF00390A),
    onTertiary = Color(0xFF00390A),
    onBackground = Color.White,
    onSurface = Color.White,
)

// アプリケーション用のセマンティックカラー定義（ライトモード用）
// グリーンテーマに合わせ、正解色も馴染みの良い色に微調整
private val LightAppColors = AppColors(
    correctBorder = Color(0xFF2E7D32),
    correctBackground = Color(0xFFE8F5E9),
    wrongBorder = Color(0xFFC62828),
    wrongBackground = Color(0xFFFFEBEE),
    selectedBackground = Color(0xFFE0E0E0)
)

// アプリケーション用のセマンティックカラー定義（ダークモード用）
private val DarkAppColors = AppColors(
    correctBorder = Color(0xFF81C784),
    correctBackground = Color(0xFF1B5E20),
    wrongBorder = Color(0xFFE57373),
    wrongBackground = Color(0xFFB71C1C),
    selectedBackground = Color(0xFF424242)
)

@Composable
fun CargoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val appColors = if (darkTheme) DarkAppColors else LightAppColors

    CompositionLocalProvider(
        LocalAppColors provides appColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
