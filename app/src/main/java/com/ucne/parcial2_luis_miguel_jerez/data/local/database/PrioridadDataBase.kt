package com.ucne.parcial2_luis_miguel_jerez.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ucne.parcial2_luis_miguel_jerez.data.local.dao.PrioridadesDao
import com.ucne.parcial2_luis_miguel_jerez.data.local.entity.Prioridades

@Database(entities = [Prioridades::class], version = 2)
abstract class PrioridadDataBase: RoomDatabase() {
    abstract fun dao(): PrioridadesDao
}