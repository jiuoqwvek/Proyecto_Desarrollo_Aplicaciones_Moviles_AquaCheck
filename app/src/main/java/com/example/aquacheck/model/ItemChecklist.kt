package com.example.aquacheck.model

//Datos que debe revisar el supervisor de buceo
data class ItemChecklist(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val estado: EstadoItem = EstadoItem.PENDIENTE,
    val observacion: String = ""   // Clase 1: registro de observaciones
)