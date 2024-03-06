package com.ucne.parcial2_luis_miguel_jerez.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.ucne.parcial2_luis_miguel_jerez.data.local.entity.Prioridades
import kotlinx.coroutines.flow.Flow

@Dao
interface PrioridadesDao {
    @Upsert
    suspend fun upsert(Prioridad: Prioridades)

    @Delete
    suspend fun delete(Prioridad: Prioridades)

    @Query("Select * From table_prioridades")
    fun getAll(): Flow<List<Prioridades>>
}