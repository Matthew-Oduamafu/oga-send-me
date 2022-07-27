package ogasendme.delivery.ltd.ogasendme.screens.splash

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.navigation.Screens
import ogasendme.delivery.ltd.ogasendme.utils.AppColors
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils

@SuppressLint("CoroutineCreationDuringComposition")
@Preview
@Composable
fun SplashScreen(navController: NavController = NavHostController(LocalContext.current)) {
    val showLogin = remember { mutableStateOf(false) }
    var isRegister = true


    if (!showLogin.value) {
        SplashAnimation()

        val scope = rememberCoroutineScope()
        scope.launch {
            delay(100)
            showLogin.value = true
        }
    } else {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White,
            elevation = 0.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.delivery_man),
                        contentDescription = stringResource(id = R.string.image_of_delivery_guy),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(top = 8.dp)
                            .fillMaxHeight(0.4f)
                    )
                    Text(
                        text = "Fast and Reliable\nDeliveries",
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 0.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 36.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )

                    Text(
                        text = "Find all that you need and have them\ndelivered to you",
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                }



                Surface(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 28.dp)
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = CircleShape, color = Color.White, elevation = 0.dp,
                    border = BorderStroke(2.dp, color = AppColors.green)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RegisterOrLoginButton(
                            title = "Register",
                            navController = navController,
                            isRegister = isRegister
                        )
                        isRegister = false
                        RegisterOrLoginButton(
                            title = "Login",
                            navController = navController,
                            isRegister = isRegister
                        )
                    }
                }
//                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
}


@Composable
fun SplashAnimation() {
    AndroidView(
        factory = {
            View.inflate(it, R.layout.splash_animation, null)
        },
        modifier = Modifier.fillMaxSize()
    )
}



@Composable
fun RegisterOrLoginButton(
    title: String,
    navController: NavController,
    isRegister: Boolean
) {
    val (getDisplayWidth, _) = AppUtils.screenHeightAndWidth(LocalContext.current)

    Button(
        modifier = Modifier
            .fillMaxHeight()
            .width(getDisplayWidth.dp.times(0.52f)),
        onClick = {
            navController.also {
                it.popBackStack();
                if (isRegister) {
                    it.navigate(Screens.RegisterScreen.route)
                } else {
                    it.navigate(Screens.LoginScreen.route)
                }
            }
        },
        colors = buttonColors(
            backgroundColor = if (isRegister) AppColors.green else Color.White,
            disabledBackgroundColor = Color.White
        ),
        enabled = true,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        shape = CircleShape
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            color = if (isRegister) Color.White else AppColors.green,
            fontFamily = FontFamily(Font(R.font.poppins_regular))
        )
    }
}