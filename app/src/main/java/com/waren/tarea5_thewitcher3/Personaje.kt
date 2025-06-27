package com.waren.tarea5_thewitcher3

import java.io.Serializable

data class Personaje(
    val nombre: String,
    val imagenResId: Int,
    val descripcion: String
) : Serializable