package ru.pashchenko.smartapp.presentation.device

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pashchenko.smartapp.data.device.enums.ColorType
import ru.pashchenko.smartapp.data.device.enums.PerfomanceType
import ru.pashchenko.smartapp.data.device.items.Light
import ru.pashchenko.smartapp.presentation.common.DropdownInputTemplate

@Composable
fun LightComponent(light: Light, context: Context) {
    Text(
        text = if (light.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(checked = light.status, onCheckedChange = { light.status = it })
    if (light.status) {
        val suggestions = ColorType.entries.toTypedArray()

        DropdownInputTemplate(
            suggestions = suggestions,
            selectedElement = light.color,
            getStringValue = { it.getTranslation(context) },
            onValueChange = { light.color = it },
            label = "Выберите интенсивность"
        )
    }
}