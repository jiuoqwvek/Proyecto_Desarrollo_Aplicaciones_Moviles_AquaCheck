package com.example.aquacheck.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            composable(Rutas.LOGIN) { RoutePlaceholder("Iniciar sesión") }
            composable(Rutas.INICIO) { RoutePlaceholder("Inicio") }
            composable(Rutas.PRECHEQUEO) { PreChequeoScreen() }
            composable(Rutas.CHECKLIST) { RoutePlaceholder("Checklist") }
            composable(Rutas.RESUMEN) { ResumenScreen() }
            composable(Rutas.HISTORIAL) { RoutePlaceholder("Historial") }
            composable(Rutas.PERFIL) { RoutePlaceholder("Perfil") }
        }
    }
}

@Composable
private fun RoutePlaceholder(title: String) {
    Text(text = title)
}
