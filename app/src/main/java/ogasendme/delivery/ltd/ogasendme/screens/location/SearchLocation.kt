package ogasendme.delivery.ltd.ogasendme.screens.location

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.screens.food.NavIconOrAddOrRemoveIcon
import ogasendme.delivery.ltd.ogasendme.screens.food.SearchBox
import ogasendme.delivery.ltd.ogasendme.utils.AppColors
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils

private const val TAG = "SearchLocation"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchLocationScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)) {
                        SearchBox(
                            label = stringResource(id = R.string.search_street_or_city),
                            onSearch = {
                                Log.d(TAG, "SearchLocation: $it")
                            }
                        )
                    }
                },
                navigationIcon = {
                    Box(modifier = Modifier.padding(start = 4.dp)) {
                        NavIconOrAddOrRemoveIcon(
                            painterResource(id = R.drawable.ic_close),
                            AppColors.green,
                            iconClicked = { navController.also {
                                it.popBackStack()
//                                it.popBackStack()
                            } }
                        )
                    }
                },
                actions = {
                    Box(modifier = Modifier.size(10.dp))
                },
                modifier = Modifier.height(65.dp),
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        },
        backgroundColor = Color.White,
    ) {
        val (_, getDisplayHeight, screenArea) = AppUtils.screenHeightAndWidth(LocalContext.current)
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 4.dp, end = 12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
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
                        color = Color.LightGray.copy(0.37f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_history_24),
                            contentDescription = "Current location",
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(7.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(getDisplayHeight.dp.times(0.1f))
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Sompa Hostel",
                            style = MaterialTheme.typography.caption,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            textAlign = TextAlign.Left,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Text(
                            text = "Kumasi, Ghana",
                            style = MaterialTheme.typography.caption,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            textAlign = TextAlign.Left,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

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
                        color = Color.LightGray.copy(0.37f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_history_24),
                            contentDescription = "Current location",
                            tint = Color.Black,
                            modifier = Modifier
                                .padding(7.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(getDisplayHeight.dp.times(0.1f))
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Tech Junction",
                            style = MaterialTheme.typography.caption,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            textAlign = TextAlign.Left,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Text(
                            text = "Accra Road, Kumasi, Ghana",
                            style = MaterialTheme.typography.caption,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            textAlign = TextAlign.Left,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}