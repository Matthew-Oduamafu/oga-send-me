package ogasendme.delivery.ltd.ogasendme.screens.orders

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.screens.food.OgaTopAppBar
import ogasendme.delivery.ltd.ogasendme.utils.AppColors

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DeliveryLocationMapScreen(navController: NavController) {
    Scaffold(
        topBar = {
            val indecePos = LatLng(6.6775, -1.5720)
            val indeceHall = MarkerState(position = indecePos)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(indecePos, 14.5f)
            }

            GoogleMap(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(2 / 3f),
                cameraPositionState = cameraPositionState
            ) {
                Marker(state = indeceHall, title = "Indece")
            }
            OgaTopAppBar(
                title = null,
                bgColor = Color.Transparent,
                iconBgColor = AppColors.lightLightGreen,
                icon = painterResource(id = R.drawable.ic_close),
                navController = navController,
                iconClicked = { navController.popBackStack() },
                isCart = false,
                onCartOrHelpIcon = {}
            )
        }
    ) {
//        val (getDisplayWidth, _, _) = AppUtils.screenHeightAndWidth(LocalContext.current)
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            Column(
                modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(0.35f),
                    thickness = 2.5.dp,
                    color = Color.LightGray
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.deliverying_your_order_lbl),
                        style = MaterialTheme.typography.h5,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = "Arrives between 9:00AM - 12:45AM",
                        style = MaterialTheme.typography.caption,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        modifier = Modifier.padding(start = 16.dp),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}