package com.ucne.parcial2_luis_miguel_jerez.ui.consulta

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.parcial2_luis_miguel_jerez.ui.PriorirdadScreen.PrioridadEvent
import com.ucne.parcial2_luis_miguel_jerez.ui.PriorirdadScreen.PrioridadViewModel

@Composable
fun Consulta(
    viewModel: PrioridadViewModel = hiltViewModel()
) {
    val prioridades by viewModel.prioridades.collectAsState(initial = emptyList())

    Column {
        LazyColumn{
            items(prioridades){prioridad ->
                Text(text = "ID: ${prioridad.idPrioridad}")
                Text(text = "Nombre: ${prioridad.nombre}")
                Text(text = "ID: ${prioridad.descripcion}")
                Text(text = "ID: ${prioridad.plazo}")
                Text(text = "ID: ${prioridad.esNulo}")
                Text(text = "ID: ${prioridad.creadoPor}")
                Text(text = "ID: ${prioridad.fechaCreacion}")
                Text(text = "ID: ${prioridad.modidicadoPor}")
                Text(text = "ID: ${prioridad.fechaModificacion}")
                Button(
                    onClick = { viewModel.onEvent(PrioridadEvent.Delete(prioridad))}
                ) {

                }
            }
        }
    }

}