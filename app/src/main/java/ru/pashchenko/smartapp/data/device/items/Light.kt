package ru.pashchenko.smartapp.data.device.items

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import ru.pashchenko.smartapp.data.device.Device
import ru.pashchenko.smartapp.data.device.DeviceType
import ru.pashchenko.smartapp.data.device.enums.ColorType

class Light(
    initialDeviceType: DeviceType,
    override val image: Painter,
    override val name: String,
    initialStatus: Boolean,
    initialColor: ColorType
) : Device {
    override var status by mutableStateOf(initialStatus)
    override val deviceType by mutableStateOf(initialDeviceType)
    var color by mutableStateOf(initialColor)

    fun getColorTranslation(context: Context): String {
        return color.getTranslation(context)
    }
}
