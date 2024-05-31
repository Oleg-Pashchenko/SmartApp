// MainScreen.kt
package ru.pashchenko.smartapp.presentation.common

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.res.painterResource

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pashchenko.smartapp.R
import ru.pashchenko.smartapp.data.room.Room
import ru.pashchenko.smartapp.data.room.RoomType
import ru.pashchenko.smartapp.presentation.room.RoomsComponent

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenPreview() {
    val rooms = remember { mutableStateListOf<Room>() }
    MainScreen(
        context = androidx.compose.ui.platform.LocalContext.current,
        rooms = rooms,
        onClick = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context, rooms: SnapshotStateList<Room>, onClick: (Room) -> Unit) {
    val dialogOpen = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Мои комнаты",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = {
            val suggestions = RoomType.entries.toTypedArray()
            var selectedElement by remember {
                mutableStateOf(RoomType.NONE)
            }
            val kitchenPainter = painterResource(id = R.drawable.kitchen)
            val bedroomPainter = painterResource(id = R.drawable.bedroom)
            val livingRoomPainter = painterResource(id = R.drawable.livingroom)
            val toiletRoomPainter = painterResource(id = R.drawable.bathroom)
            val hallRoomPainter = painterResource(id = R.drawable.hall)
            val unknownRoomPainter = painterResource(id = R.drawable.unknown)

            CreateTemplateComponent(
                onClick = { name ->
                    val room = Room(
                        selectedElement,
                        when (selectedElement) {
                            RoomType.LIVING_ROOM -> livingRoomPainter
                            RoomType.KITCHEN -> kitchenPainter
                            RoomType.BEDROOM -> bedroomPainter
                            RoomType.TOILET -> toiletRoomPainter
                            RoomType.HALL -> hallRoomPainter
                            else -> unknownRoomPainter
                        },
                        name,
                        mutableStateListOf()
                    )
                    rooms.add(room)
                    selectedElement = RoomType.LIVING_ROOM
                },
                dialogOpen = dialogOpen,
                suggestions = suggestions,
                selectedElement = selectedElement,
                getStringValue = { it.getTranslation(context) },
                onValueChange = { selectedElement = it },
                labelName = "Имя комнаты",
                labelType = "Тип комнаты"
            )
            Column(
                modifier = Modifier.padding(top = 60.dp)
            ) {
                RoomsComponent(
                    rooms = rooms,
                    onClick = onClick
                )
            }
        },
        floatingActionButton = {
            AddButtonComponent(onClick = { dialogOpen.value = true})
        }
    )
}
