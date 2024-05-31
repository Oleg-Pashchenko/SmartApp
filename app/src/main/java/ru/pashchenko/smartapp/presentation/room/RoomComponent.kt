package ru.pashchenko.smartapp.presentation.room

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ru.pashchenko.smartapp.data.device.items.AirConditioner
import ru.pashchenko.smartapp.data.device.items.Light
import ru.pashchenko.smartapp.data.room.Room
import ru.pashchenko.smartapp.presentation.common.DeleteTemplateComponent

@Composable
fun RoomsComponent(rooms: SnapshotStateList<Room>, onClick: (Room) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(rooms.size) { index ->
            val room = rooms[index]
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .clickable { onClick(room) },
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
            ) {
                Box {
                    Image(
                        painter = room.image,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray.copy(alpha = 0.5f)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        DeleteTemplateComponent(
                            onClick = {
                                rooms.remove(room)
                            }
                        )
                        Text(
                            text = room.name,
                            modifier = Modifier.padding(8.dp),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}