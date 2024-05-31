package ru.pashchenko.smartapp.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import ru.pashchenko.smartapp.ui.themes.Pink40
import ru.pashchenko.smartapp.ui.themes.Pink80
import ru.pashchenko.smartapp.ui.themes.Purple40
import ru.pashchenko.smartapp.ui.themes.Purple80

val TopRoundedCornerShape = RoundedCornerShape(
    topStart = 15.dp,
    topEnd = 15.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

@Composable
fun DeviceTemplateComponent(
    image: Painter,
    name: String,
    content: @Composable () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Box для изображения и кнопки удаления
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(TopRoundedCornerShape) // Применяем обрезку формы для верхних углов
                )

                // Кнопка удаления, расположенная в верхнем правом углу
                DeleteTemplateComponent(
                    onClick = { onDelete() },

                )
            }

            // Текст под изображением
            Text(
                text = name,
                modifier = Modifier.padding(8.dp),
                color = Color.Black
            )

            // Колонка для остального содержимого
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), // Отступ для разделения содержимого
                horizontalAlignment = Alignment.Start,
            ) {
                content()
            }
        }
    }
}
