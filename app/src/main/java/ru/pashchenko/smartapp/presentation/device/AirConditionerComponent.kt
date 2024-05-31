package ru.pashchenko.smartapp.presentation.device;

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.pashchenko.smartapp.data.device.enums.PerfomanceType
import ru.pashchenko.smartapp.data.device.items.AirConditioner
import ru.pashchenko.smartapp.presentation.common.DropdownInputTemplate
import kotlin.math.roundToInt

@Composable
fun AirConditionerComponent(airConditioner: AirConditioner, context: Context) {
    Text(
        text = if (airConditioner.status) "Статус: Включено" else "Статус: Выключено",
        modifier = Modifier.padding(8.dp)
    )
    Switch(
        checked = airConditioner.status,
        onCheckedChange = { airConditioner.status = it }
    )

    if (airConditioner.status) {
        Text(
            text = "Температура: " + airConditioner.temperature.toString() + "°C",
            modifier = Modifier.padding(8.dp, 12.dp, 8.dp, 8.dp)
        )
        Slider(
            value = airConditioner.temperature,
            onValueChange = { airConditioner.temperature = (it * 10).roundToInt() / 10f },
            valueRange = 0f..30f,
            steps = 300,
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Gray,
                activeTickColor = Color.Gray
            )
        )
        val suggestions = PerfomanceType.entries.toTypedArray()

        DropdownInputTemplate(
            suggestions = suggestions,
            selectedElement = airConditioner.perfomanceType,
            getStringValue = { it.getTranslation(context) },
            onValueChange = { airConditioner.perfomanceType = it },
            label = "Выберите интенсивность"
        )
    }
}