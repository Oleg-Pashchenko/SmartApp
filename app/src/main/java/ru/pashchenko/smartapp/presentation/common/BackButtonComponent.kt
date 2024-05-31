import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
@Composable
fun BackButtonComponent(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.popBackStack() },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = null
        )
    }
}
