package ogasendme.delivery.ltd.ogasendme.screens.provider_products

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.data.fakeDataStore
import ogasendme.delivery.ltd.ogasendme.navigation.Screens
import ogasendme.delivery.ltd.ogasendme.screens.food.OgaTopAppBar
import ogasendme.delivery.ltd.ogasendme.utils.AppColors
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils
import ogasendme.delivery.ltd.ogasendme.utils.Constants

private const val TAG = "SelectedProductDetailsS"

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectedProductDetailsScreen(navController: NavController) {
    val (getDisplayWidth, getDisplayHeight, _) = AppUtils.screenHeightAndWidth(LocalContext.current)

    Scaffold(
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(getDisplayHeight.dp.times(0.35f)),
                color = Color.White
            ) {
                ShowImageOrProductImage(getDisplayHeight, scalingFactor = 0.35f)

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Log.d(TAG, "FoodOrProductItemScreen: custom top app bar")
                    OgaTopAppBar(
                        title = null,
                        bgColor = Color.Transparent,
                        iconBgColor = AppColors.green,
                        icon = painterResource(id = R.drawable.ic_close),
                        navController = navController,
                        iconClicked = { navController.popBackStack() },
                        onCartOrHelpIcon = { navController.navigate(Screens.CartScreen.route) }
                    )
                }
            }
        },
        backgroundColor = Color.White,
        floatingActionButton = {
            Button(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                colors = buttonColors(
                    backgroundColor = AppColors.green,
                    disabledBackgroundColor = AppColors.green
                ),
                modifier = Modifier
                    .width(getDisplayWidth.dp.times(0.7f))
                    .height(getDisplayHeight.dp.times(0.051f))
            ) {
                Text(
                    text = "Add for ${Constants.CEDI} 2.00", style = TextStyle(
                        color = Color.White,
                        fontSize = 13.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val item = fakeDataStore[0]
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        )
                    ) {
                        append(item.itemName + "\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        )
                    ) {
                        append("${Constants.CEDI} 1.00\n\n")
                    }

                    withStyle(
                        style = SpanStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        )
                    ) {
                        append(item.itemDescription)
                    }
                },
                textAlign = TextAlign.Center
            )
        }
    }
}