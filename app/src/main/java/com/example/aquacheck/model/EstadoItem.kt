package com.example.aquacheck.model

//Estado que pueden tener los ítems del checklist
enum class EstadoItem (val titulo: String) {
    PENDIENTE("Pendiente"),
    APROBADO("Aprobado"),
    NO_APROBADO("No Aprobado")
}