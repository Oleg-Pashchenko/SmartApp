package ru.pashchenko.smartapp.data.device.items

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import ru.pashchenko.smartapp.data.device.Device
import ru.pashchenko.smartapp.data.device.DeviceType
import ru.pashchenko.smartapp.data.device.enums.PerfomanceType

class AirConditioner(
    initialDeviceType: DeviceType,
    override val image: Painter,
    override val name: String,
    initialStatus: Boolean,
    initialTemperature: Float,
    initialPerfomanceType: PerfomanceType
) : Device {
    override val deviceType by mutableStateOf(initialDeviceType)
    override var status by mutableStateOf(initialStatus)
    var temperature by mutableFloatStateOf(initialTemperature)
    var perfomanceType by mutableStateOf(initialPerfomanceType)

    fun getPerfomanceTypeTranslation(context: Context): String {
        return perfomanceType.getTranslation(context)
    }
}

