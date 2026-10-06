package com.example.aquacheck.model

//Resultado preliminar del pre-chequeo
enum class Resultado(val titulo: String, val descripcion: String) {
    INCOMPLETO("Incompleto", "Quedan ítems sin revisar."),
    CUMPLE("Cumple", "Todos los ítems revisados cumplen."),
    OBSERVADO("Observado", "Hay ítems con observaciones que el supervisor debe revisar."),
    REQUIERE_REVISION("Requiere revisión", "Uno o más ítems no cumplen. El supervisor debe revisar antes de continuar.")
}