package com.example.aquacheck.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aquacheck.ui.components.BarraInferior
import com.example.aquacheck.ui.components.BarraSuperior
import com.example.aquacheck.ui.screens.PreChequeoScreen
import com.example.aquacheck.ui.screens.ResumenScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val showBars = currentRoute != Rutas.LOGIN

    Scaffold(
        topBar = { if (showBars) BarraSuperior() },
        bottomBar = {
            if (showBars) {
                BarraInferior(currentRoute = currentRoute) { route ->
                    navController.navigate(route) {
                        popUpTo(Rutas.INICIO)
                        launchSingleTop = true
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Rutas.LOGIN,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Rutas.LOGIN) {
                RoutePlaceholder(
                    title = "Iniciar sesión",
                    actionLabel = "Entrar",
                    onAction = { navController.navigate(Rutas.INICIO) }
                )
            }
            composable(Rutas.INICIO) {
                RoutePlaceholder(
                    title = "Inicio",
                    actionLabel = "Nuevo pre-chequeo",
                    onAction = { navController.navigate(Rutas.PRECHEQUEO) }
                )
            }
            composable(Rutas.PRECHEQUEO) {
                PreChequeoScreen(
                    onContinuar = { navController.navigate(Rutas.RESUMEN) }
                )
            }
            composable(Rutas.CHECKLIST) { RoutePlaceholder("Checklist") }
            composable(Rutas.RESUMEN) {
                ResumenScreen(
                    onFinalizar = {
                        navController.navigate(Rutas.INICIO) {
                            popUpTo(Rutas.INICIO)
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Rutas.HISTORIAL) { RoutePlaceholder("Historial") }
            composable(Rutas.PERFIL) { RoutePlaceholder("Perfil") }
        }
    }
}

@Composable
private fun RoutePlaceholder(
    title: String,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Text(text = title)
        if (actionLabel != null && onAction != null) {
            Button(onClick = onAction, modifier = Modifier.padding(top = 16.dp)) {
                Text(actionLabel)
            }
        }
    }
}
