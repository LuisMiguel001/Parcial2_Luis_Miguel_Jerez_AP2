package com.ucne.parcial2_luis_miguel_jerez.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("table_prioridades")
data class Prioridades(
    @PrimaryKey(autoGenerate = true)
    val idPrioridad : Int = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val plazo: Int = 0,
    val esNulo: Boolean = false,
    val creadoPor: Int = 0,
    val fechaCreacion: String = "",
    val modidicadoPor: Int = 0,
    val fechaModificacion: String = "",
    val imagen: String = "",
)
