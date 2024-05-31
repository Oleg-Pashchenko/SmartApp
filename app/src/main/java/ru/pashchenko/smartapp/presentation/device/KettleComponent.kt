package ru.pashchenko.smartapp.presentation.device

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pashchenko.smartapp.data.device.items.Kettle


@Composable
fun KettleComponent(kettle: Kettle) {
    Text(
    text = if (kettle.status) "Статус: Включено" else "Статус: Выключено",
    modifier = Modifier.padding(8.dp)
    )
    Switch(checked = kettle.status, onCheckedChange = { kettle.status = it })
}



