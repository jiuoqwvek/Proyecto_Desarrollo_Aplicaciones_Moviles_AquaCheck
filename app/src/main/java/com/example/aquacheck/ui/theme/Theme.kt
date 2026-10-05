package com.example.aquacheck.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//Solo se usan los 5 colores de la Clase 2.
//Los tonos suaves (Card, selección) son el mismo azul secundario con transparencia.
//Siempre tema claro y sin colores dinámicos, para que se lea bien al sol.
private val AquaColorScheme = lightColorScheme(
    primary = AzulPrincipal,
    onPrimary = Color.White,
    primaryContainer = AzulSecundario.copy(alpha = 0.25f),
    onPrimaryContainer = TextoOscuro,
    secondary = AzulSecundario,
    onSecondary = TextoOscuro,
    secondaryContainer = AzulSecundario.copy(alpha = 0.25f),
    onSecondaryContainer = TextoOscuro,
    background = FondoClaro,
    onBackground = TextoOscuro,
    surface = FondoClaro,
    onSurface = TextoOscuro,
    surfaceVariant = AzulSecundario.copy(alpha = 0.12f),
    onSurfaceVariant = TextoOscuro,
    surfaceContainer = Color.White,
    surfaceContainerHighest = AzulSecundario.copy(alpha = 0.12f),
    error = RojoAlerta,
    onError = Color.White
)

@Composable
fun AquaCheckTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AquaColorScheme,
        typography = Typography,
        content = content
    )
}