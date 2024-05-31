package ru.pashchenko.smartapp


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pashchenko.smartapp.data.room.Room
import ru.pashchenko.smartapp.presentation.common.MainScreen
import ru.pashchenko.smartapp.presentation.room.RoomScreen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val context = this


            val rooms = remember {
                mutableStateListOf<Room>()
            }
            val navController = rememberNavController()
            val mainScreen = "main"
            NavHost(
                navController = navController,
                startDestination = mainScreen
            ) {
                composable(mainScreen) {
                    MainScreen(
                        context = context,
                        rooms = rooms
                    ) { room ->
                        val route = "room/${room.id}"
                        navController.navigate(route)
                    }
                }
                repeat(100) { index ->
                    val route = "room/${index}"
                    composable(route = route) {
                        RoomScreen(context, room = rooms[index], navController)
                    }
                }
            }
        }
    }
}