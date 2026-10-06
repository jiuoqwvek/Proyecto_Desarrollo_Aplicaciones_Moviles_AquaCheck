package com.example.aquacheck.model

//Usuario para el login
data class Usuario(
    val nombre: String,
    val correo: String,
    val clave: String,
    val rol: String
)