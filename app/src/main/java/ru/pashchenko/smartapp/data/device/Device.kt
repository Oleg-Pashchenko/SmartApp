package ru.pashchenko.smartapp.data.device


import androidx.compose.ui.graphics.painter.Painter;

public interface Device {
    val deviceType: DeviceType
    val image: Painter
    val name: String
    val status: Boolean
}

