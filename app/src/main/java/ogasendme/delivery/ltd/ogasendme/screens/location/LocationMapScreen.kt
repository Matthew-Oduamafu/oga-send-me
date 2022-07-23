package ogasendme.delivery.ltd.ogasendme.screens.location

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import ogasendme.delivery.ltd.ogasendme.navigation.Screens
import ogasendme.delivery.ltd.ogasendme.screens.food.OgaTopAppBar
import ogasendme.delivery.ltd.ogasendme.screens.food.SearchBox
import ogasendme.delivery.ltd.ogasendme.utils.AppColors
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils

private const val TAG = "LocationMapScreen"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LocationMapScreen(navController: NavController, msg: String) {
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
                isCart = null,
                onCartOrHelpIcon = {}
            )
        }
    ) {
        val (_, _, screenArea) = AppUtils.screenHeightAndWidth(LocalContext.current)


        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White,
            shape = RoundedCornerShape(topStartPercent = 5, topEndPercent = 5),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider(
                    modifier = Modifier
                        .fillMaxWidth(0.35f),
                    thickness = 2.5.dp,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = msg,
                    style = MaterialTheme.typography.h6,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    textAlign = TextAlign.Center
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {

                    Box(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp)) {
                        SearchBox(
                            label = stringResource(id = R.string.search_street_or_city),
                            onFocused = {
                                if (it.isFocused) {
                                    navController.navigate(Screens.SearchLocationScreen.route)
                                }
                            },
                            onSearch = {
                                Log.d(TAG, "LocationMapScreen: $it")
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { },
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            modifier = Modifier.size(screenArea.dp.times(0.0001f)),
                            shape = CircleShape,
                            color = AppColors.lightLightGreen.copy(0.37f)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.nav_1),
                                contentDescription = "Current location",
                                tint = AppColors.green,
                                modifier = Modifier
                                    .padding(7.dp)
                            )
                        }
                        Text(
                            text = stringResource(id = R.string.use_current_location_lbl),
                            style = MaterialTheme.typography.body2,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            textAlign = TextAlign.Start,
                            color = AppColors.green,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}