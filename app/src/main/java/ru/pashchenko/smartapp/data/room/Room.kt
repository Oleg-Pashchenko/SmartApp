package ru.pashchenko.smartapp.data.room

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.painter.Painter
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ru.pashchenko.smartapp.data.device.Device
import ru.pashchenko.smartapp.data.room.RoomType

class Room(
    initialRoomType: RoomType,
    val image: Painter,
    val name: String,
    val devices: SnapshotStateList<Device>
) {
    companion object {
        private var currentId = 0
        private fun getNextId() = currentId++
    }

    val id: Int = getNextId()
    var roomType by mutableStateOf(initialRoomType)

    fun getRoomTypeTranslation(context: Context): String {
        return roomType.getTranslation(context)
    }
}
