package com.example.aquacheck.model

//Datos del Pre-Chequeo
data class PreChequeo(
    val id: Long = 0,
    val supervisor: String = "",
    val fecha: String = "",
    val centro: Centro? = null,
    val buzo: Buzo? = null,
    val items: List<ItemChecklist> = emptyList(),
    val resultado: Resultado? = null
)