package ru.pashchenko.smartapp.data.device.items

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import ru.pashchenko.smartapp.data.device.Device
import ru.pashchenko.smartapp.data.device.DeviceType

class Kettle(
    initialDeviceType: DeviceType,
    override val image: Painter,
    override val name: String,
    initialStatus: Boolean
) : Device {
    override val deviceType by mutableStateOf(initialDeviceType)
    override var status by mutableStateOf(initialStatus)
}
