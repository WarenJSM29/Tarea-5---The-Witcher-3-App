package com.waren.tarea5_thewitcher3

import java.io.Serializable

data class Momento(
    val titulo: String,
    val imagenResId: Int,
    val videoUrl: String, // URL embebida
    val descripcion: String
) : Serializable