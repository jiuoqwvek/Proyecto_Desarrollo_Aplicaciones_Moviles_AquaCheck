package com.example.aquacheck.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private val elementosPrechequeo = listOf(
    "Máscara y tubo",
    "Regulador",
    "Chaleco compensador",
    "Cilindro de aire",
    "Aletas"
)

@Composable
fun PreChequeoScreen(onContinuar: () -> Unit = {}) {
    val seleccionados = remember { mutableStateListOf<String>() }
    val completo = seleccionados.size == elementosPrechequeo.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Pre-chequeo de equipamiento")
        Text("Confirma que cada elemento está listo antes de continuar.")
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(elementosPrechequeo) { elemento ->
                OpcionSeleccionable(
                    texto = elemento,
                    seleccionada = elemento in seleccionados,
                    onSeleccionar = {
                        if (elemento in seleccionados) seleccionados.remove(elemento)
                        else seleccionados.add(elemento)
                    }
                )
            }
        }
        Button(onClick = onContinuar, enabled = completo) {
            Text("Continuar")
        }
    }
}
