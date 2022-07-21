package ogasendme.delivery.ltd.ogasendme.screens.login

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.components.AllLoginOptions
import ogasendme.delivery.ltd.ogasendme.components.LoginOrSignUpWithPhoneNumber
import ogasendme.delivery.ltd.ogasendme.navigation.Screens

private const val TAG = "LoginScreen"

@Composable
fun LoginScreen(navController: NavController) {
    val phoneNumber = remember { mutableStateOf("") }
    remember(phoneNumber) {
        mutableStateOf(phoneNumber.value.trim().length == 10)
    }
    val labelId = stringResource(R.string.enter_phone_number)


    Surface(modifier = Modifier.fillMaxSize(), elevation = 0.dp) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    modifier = Modifier,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 48.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                )

                Spacer(modifier = Modifier.fillMaxHeight(0.03f))

                AllLoginOptions(navController)
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // login with phone
                Text(
                    text = stringResource(id = R.string.login_with_phone),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 26.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.015f))
                LoginOrSignUpWithPhoneNumber(phoneNumber, navController) {
                    Log.d(TAG, "LoginScreen: Signing in")
                    navController.navigate(Screens.OTPCodeScreen.route)
                }
            }
        }
    }
}
