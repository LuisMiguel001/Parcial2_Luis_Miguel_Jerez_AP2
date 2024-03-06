package com.ucne.parcial2_luis_miguel_jerez.data.repository

import com.ucne.parcial2_luis_miguel_jerez.data.local.dao.PrioridadesDao
import com.ucne.parcial2_luis_miguel_jerez.data.local.entity.Prioridades
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrioridadRepository @Inject constructor(
    private val repository: PrioridadesDao
) {
    suspend fun upsert(prioridades: Prioridades){
        repository.upsert(prioridades)
    }

    suspend fun delete(prioridades: Prioridades){
        repository.delete(prioridades)
    }

    fun getAll(): Flow<List<Prioridades>> {
        return repository.getAll()
    }
}