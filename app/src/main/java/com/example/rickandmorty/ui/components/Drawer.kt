import android.hardware.biometrics.BiometricManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rickandmorty.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
    items: List<String>
) {
    Column() {
        Image(
            painter = painterResource(id = R.drawable.ricky_morty_bg),
            contentDescription = "bg",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp))

        items.forEach{ item ->
            DrawerItem(item = item){

            }
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    }
}

@Composable
fun DrawerItem(
    item: String,
    onItemClick: (String) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .background(Color.Transparent)
            .padding(8.dp)
            .clickable { onItemClick(item) },
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = Icons.Filled.ExitToApp,
            contentDescription = "menu",
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = item,
            style = TextStyle(fontSize = 18.sp),
            color = Color.Black
        )
    }

}