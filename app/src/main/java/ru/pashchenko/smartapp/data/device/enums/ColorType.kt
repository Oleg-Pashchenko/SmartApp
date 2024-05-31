package ru.pashchenko.smartapp.data.device.enums


import android.content.Context
import ru.pashchenko.smartapp.R

enum class ColorType(val stringResId: Int) {
    NONE(R.string.color_type_none),
    RED(R.string.color_type_red),
    GREEN(R.string.color_type_green),
    BLUE(R.string.color_type_blue),
    PURPLE(R.string.color_type_purple),
    ORANGE(R.string.color_type_orange),
    YELLOW(R.string.color_type_yellow);

    fun getTranslation(context: Context): String {
        return context.getString(stringResId)
    }
}