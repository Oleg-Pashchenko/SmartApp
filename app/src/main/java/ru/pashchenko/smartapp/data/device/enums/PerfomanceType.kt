package ru.pashchenko.smartapp.data.device.enums

import android.content.Context
import ru.pashchenko.smartapp.R

enum class PerfomanceType(val stringResId: Int) {
    NONE(R.string.perfomance_type_none),
    MINIMUM(R.string.perfomance_type_minimum),
    AVERAGE(R.string.perfomance_type_average),
    MAXIMUM(R.string.perfomance_type_maximum);


    fun getTranslation(context: Context): String {
        return context.getString(stringResId)
    }
}