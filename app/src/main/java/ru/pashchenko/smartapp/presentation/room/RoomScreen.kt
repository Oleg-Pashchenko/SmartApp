package ru.pashchenko.smartapp.presentation.room


import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.pashchenko.smartapp.data.room.Room

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoomScreen(context: Context, room: Room,  navController: NavController){
    RoomDetails(
        context = context,
        devices = room.devices,
        navController = navController)
}