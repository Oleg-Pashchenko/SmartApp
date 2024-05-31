package ru.pashchenko.smartapp.presentation.room

import BackButtonComponent
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.pashchenko.smartapp.R
import ru.pashchenko.smartapp.data.device.Device
import ru.pashchenko.smartapp.data.device.DeviceType
import ru.pashchenko.smartapp.data.device.enums.ColorType
import ru.pashchenko.smartapp.data.device.enums.PerfomanceType
import ru.pashchenko.smartapp.data.device.items.AirConditioner
import ru.pashchenko.smartapp.data.device.items.Kettle
import ru.pashchenko.smartapp.data.device.items.Light
import ru.pashchenko.smartapp.data.device.items.Socket
import ru.pashchenko.smartapp.data.device.items.Tv
import ru.pashchenko.smartapp.presentation.common.AddButtonComponent
import ru.pashchenko.smartapp.presentation.common.CreateTemplateComponent
import ru.pashchenko.smartapp.presentation.common.DeviceTemplateComponent
import ru.pashchenko.smartapp.presentation.device.AirConditionerComponent
import ru.pashchenko.smartapp.presentation.device.KettleComponent
import ru.pashchenko.smartapp.presentation.device.LightComponent
import ru.pashchenko.smartapp.presentation.device.SocketComponent
import ru.pashchenko.smartapp.presentation.device.TvComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RoomDetails(context: Context, devices: SnapshotStateList<Device>,  navController: NavController) {

    val dialogOpen = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Устройства",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = {
            val suggestions = DeviceType.entries.toTypedArray()
            var selectedElement by remember {
                mutableStateOf(DeviceType.NONE)
            }
            val lightPainter = painterResource(id = R.drawable.light)
            val conditionerPainter = painterResource(id = R.drawable.conditioner)
            val kettlePainter = painterResource(id = R.drawable.kettle)
            val socketPainter = painterResource(id = R.drawable.socket)
            val tvPainter = painterResource(id = R.drawable.tv)

            CreateTemplateComponent(
                onClick = { name ->
                    val device = when (selectedElement) {
                        DeviceType.LIGHT -> Light(DeviceType.LIGHT, lightPainter, name, false, ColorType.RED)

                        DeviceType.KETTLE -> Kettle(DeviceType.KETTLE, kettlePainter, name, false)

                        DeviceType.AIR_CONDITIONER -> AirConditioner(
                            DeviceType.AIR_CONDITIONER,
                            conditionerPainter,
                            name,
                            false,
                            10.0f,
                            PerfomanceType.AVERAGE
                        )
                        
                        DeviceType.SOCKET -> Socket(DeviceType.SOCKET, socketPainter, name, false)
                        
                        DeviceType.TV -> Tv(DeviceType.TV, tvPainter, name, false)

                        else -> Light(DeviceType.LIGHT, lightPainter, "Свет", false, ColorType.BLUE)
                    }
                    devices.add(device)
                    selectedElement = DeviceType.NONE
                },
                dialogOpen = dialogOpen,
                suggestions = suggestions,
                selectedElement = selectedElement,
                getStringValue = { it.getTranslation(context) },
                onValueChange = { selectedElement = it },
                labelName = "Название устройства",
                labelType = "Тип устройства"
            )
            Column(
                modifier = Modifier.padding(top = 60.dp)
            )
            {
                LazyVerticalGrid(
                    GridCells.Fixed(1),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    devices.forEach { device ->
                        item {
                            DeviceTemplateComponent(
                                image = device.image,
                                name = device.name,
                                onDelete = { devices.remove(device) },
                                content = {
                                    when (device) {
                                        is Light -> LightComponent(light = device, context)
                                        is AirConditioner -> AirConditionerComponent(airConditioner = device, context)
                                        is Kettle -> KettleComponent(kettle = device)
                                        is Tv -> TvComponent(tv = device)
                                        is Socket -> SocketComponent(socket = device)
                                    }
                                })
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                BackButtonComponent(navController = navController)
                AddButtonComponent(onClick = { dialogOpen.value = true })

            }
        }
    )
}

