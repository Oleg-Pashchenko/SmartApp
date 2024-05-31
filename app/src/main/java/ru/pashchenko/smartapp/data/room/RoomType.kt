package ru.pashchenko.smartapp.data.room

import android.content.Context
import ru.pashchenko.smartapp.R

enum class RoomType(val stringResId: Int) {
    NONE(R.string.room_type_none),
    LIVING_ROOM(R.string.room_type_living_room),
    BEDROOM(R.string.room_type_bedroom),
    KITCHEN(R.string.room_type_kitchen),
    TOILET(R.string.room_type_toilet),
    HALL(R.string.room_type_hall);

    fun getTranslation(context: Context): String {
        return context.getString(stringResId)
    }
}
