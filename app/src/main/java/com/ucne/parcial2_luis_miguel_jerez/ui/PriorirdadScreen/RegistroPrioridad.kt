package com.ucne.parcial2_luis_miguel_jerez.ui.PriorirdadScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun Registro(
    viewModel: PrioridadViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val _state = state.prioridad

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(text = "Registro de Prioridad", style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            color = Color.Cyan
        )

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
            label = { Text(text = "Plazo")},
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
                    .padding(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan,
                    contentColor = Color.Black
                )
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
                    .padding(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }
    }
    state.MessageSucces?.let {
        MessageCard(message = it, color = Color.Green)
    }

    state.error?.let {
        MessageCard(message = it, color = Color.Red)
    }
}

@Composable
fun MessageCard(
    message: String,
    color: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(16.dp),
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = color
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}