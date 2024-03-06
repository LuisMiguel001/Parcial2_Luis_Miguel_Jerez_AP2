package com.ucne.parcial2_luis_miguel_jerez.ui.PriorirdadScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun Registro(
    viewModel: PrioridadViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val _state = state.prioridad

    Column {
        OutlinedTextField(
            value = _state.nombre,
            onValueChange = { viewModel.onEvent(PrioridadEvent.Nombre(it))},
            label = { Text(text = "Nombre")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.descripcion,
            onValueChange = { viewModel.onEvent(PrioridadEvent.Descripcion(it))},
            label = { Text(text = "Descripción")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.plazo.toString(),
            onValueChange = { viewModel.onEvent(PrioridadEvent.Plazo(it))},
            label = { Text(text = "Nombre")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.esNulo.toString(),
            onValueChange = { viewModel.onEvent(PrioridadEvent.EsNulo(it))},
            label = { Text(text = "EsNulo")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.creadoPor.toString(),
            onValueChange = { viewModel.onEvent(PrioridadEvent.CreadoPor(it))},
            label = { Text(text = "Creado Por")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.fechaCreacion,
            onValueChange = { viewModel.onEvent(PrioridadEvent.FechaCreacion(it))},
            label = { Text(text = "Fecha de Creación")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.modidicadoPor.toString(),
            onValueChange = { viewModel.onEvent(PrioridadEvent.ModificadoPor(it))},
            label = { Text(text = "Modificado Por")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        OutlinedTextField(
            value = _state.fechaModificacion,
            onValueChange = { viewModel.onEvent(PrioridadEvent.FechaModificacion(it))},
            label = { Text(text = "Fecha de Modificaión")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    viewModel.onEvent(PrioridadEvent.onNew)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = "New")
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }

            Button(
                onClick = {
                    viewModel.onEvent(PrioridadEvent.onSave)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
            /*Row {
            Button(
                onClick = { viewModel.onEvent(PrioridadEvent.onSave)},
                modifier = Modifier
                    .fillMaxWidth(),
            ) {

            }

            Button(
                onClick = { viewModel.onEvent(PrioridadEvent.onNew)},
                modifier = Modifier
                    .fillMaxWidth(),
            ) {

            }
        }*/
        }
    }
}