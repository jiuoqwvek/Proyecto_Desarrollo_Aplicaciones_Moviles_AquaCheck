package com.example.aquacheck.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.aquacheck.navigation.Rutas

private data class ItemBarra(val route: String, val label: String, val icon: ImageVector)

@Composable
fun BarraInferior(currentRoute: String?, onNavigate: (String) -> Unit) {
    val items = listOf(
        ItemBarra(Rutas.INICIO, "Inicio", Icons.Default.Home),
        ItemBarra(Rutas.HISTORIAL, "Historial", Icons.Default.History),
        ItemBarra(Rutas.PERFIL, "Perfil", Icons.Default.Person)
    )
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onNavigate(item.route) },
                icon = { Icon(item.icon, item.label) },
                label = { Text(item.label) }
            )
        }
    }
}
