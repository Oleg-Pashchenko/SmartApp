package ru.pashchenko.smartapp.data.device

import android.content.Context
import ru.pashchenko.smartapp.R

enum class DeviceType(val stringResId: Int) {
    NONE(R.string.device_type_none),
    LIGHT(R.string.device_type_light),
    AIR_CONDITIONER(R.string.device_type_air_conditioner),
    KETTLE(R.string.device_type_kettle),
    SOCKET(R.string.device_type_socket),
    TV(R.string.device_type_tv);

    fun getTranslation(context: Context): String {
        return context.getString(stringResId)
    }
}


