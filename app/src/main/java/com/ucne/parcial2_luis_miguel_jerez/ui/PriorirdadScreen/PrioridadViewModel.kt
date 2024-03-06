package com.ucne.parcial2_luis_miguel_jerez.ui.PriorirdadScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.parcial2_luis_miguel_jerez.data.local.entity.Prioridades
import com.ucne.parcial2_luis_miguel_jerez.data.repository.PrioridadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrioridadViewModel @Inject constructor(
    private val PrioridaRepositori: PrioridadRepository
) : ViewModel() {
    private val _state = MutableStateFlow(StatePrioridad())
    val state = _state.asStateFlow()
    val prioridades: Flow<List<Prioridades>> = PrioridaRepositori.getAll()

    fun onEvent(event: PrioridadEvent) {
        when (event) {
            is PrioridadEvent.Idprioridad -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(idPrioridad = event.id.toIntOrNull() ?: 0)
                    )
                }
            }

            is PrioridadEvent.Nombre -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(nombre = event.nombre)
                    )
                }
            }

            is PrioridadEvent.Descripcion -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(descripcion = event.descripcion)
                    )
                }
            }

            is PrioridadEvent.Plazo -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(plazo = event.plazo.toIntOrNull() ?: 0)
                    )
                }
            }

            is PrioridadEvent.EsNulo -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(esNulo = event.esnulo.toBoolean())
                    )
                }
            }

            is PrioridadEvent.CreadoPor -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(creadoPor = event.creadopor.toIntOrNull() ?: 0)
                    )
                }
            }

            is PrioridadEvent.FechaCreacion -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(fechaCreacion = event.fechaCreacion)
                    )
                }
            }

            is PrioridadEvent.ModificadoPor -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(modidicadoPor = event.modificadopor.toIntOrNull() ?: 0)
                    )
                }
            }

            is PrioridadEvent.FechaModificacion -> {
                _state.update {
                    it.copy(
                        prioridad = it.prioridad.copy(fechaModificacion = event.fechamodificacion)
                    )
                }
            }

            PrioridadEvent.onSave -> {
                val nombre = state.value.prioridad.nombre
                val descripcion = state.value.prioridad.descripcion
                val plazo = state.value.prioridad.plazo
                val esnulo = state.value.prioridad.esNulo
                val creado = state.value.prioridad.creadoPor
                val frechaCreacion = state.value.prioridad.fechaCreacion
                val modificadopor = state.value.prioridad.modidicadoPor
                val fechamodificacion = state.value.prioridad.fechaModificacion

                val prioridad = Prioridades(
                    nombre = nombre,
                    descripcion = descripcion,
                    plazo = plazo,
                    esNulo = esnulo,
                    creadoPor = creado,
                    fechaCreacion = frechaCreacion,
                    modidicadoPor = modificadopor,
                    fechaModificacion = fechamodificacion
                )

                viewModelScope.launch {
                    PrioridaRepositori.upsert(prioridad)
                }

                _state.update {
                    it.copy(
                        prioridad = Prioridades()
                    )
                }
            }

            PrioridadEvent.onNew -> {
                _state.update {
                    it.copy(
                        prioridad = Prioridades()
                    )
                }
            }

            is PrioridadEvent.Delete -> {
                viewModelScope.launch {
                    PrioridaRepositori.delete(event.prioridad)
                }
            }

            else -> {}
        }
    }
}

data class StatePrioridad(
    val isLoading: Boolean = false,
    val error: String? = null,
    val MessageSucces: String? = null,
    val prioridad: Prioridades = Prioridades()
)

sealed interface PrioridadEvent {
    data class Idprioridad(val id: String) : PrioridadEvent
    data class Nombre(val nombre: String) : PrioridadEvent
    data class Descripcion(val descripcion: String) : PrioridadEvent
    data class Plazo(val plazo: String) : PrioridadEvent
    data class EsNulo(val esnulo: String) : PrioridadEvent
    data class CreadoPor(val creadopor: String) : PrioridadEvent
    data class FechaCreacion(val fechaCreacion: String) : PrioridadEvent
    data class ModificadoPor(val modificadopor: String) : PrioridadEvent
    data class FechaModificacion(val fechamodificacion: String) : PrioridadEvent
    data class Delete(val prioridad: Prioridades) : PrioridadEvent
    data object onSave : PrioridadEvent
    data object onNew : PrioridadEvent
}