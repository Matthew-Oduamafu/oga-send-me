package ogasendme.delivery.ltd.ogasendme.screens.register

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.components.AlreadyUserOrNewUser
import ogasendme.delivery.ltd.ogasendme.components.InputPhoneNumber
import ogasendme.delivery.ltd.ogasendme.components.SignInAndSignOptions
import ogasendme.delivery.ltd.ogasendme.navigation.Screens
import ogasendme.delivery.ltd.ogasendme.utils.AppColors
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils

@Composable
fun RegisterScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White, elevation = 0.dp) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TakeUserInfo(navController)

            ColumnDivider()

            AlternateSignUpOptions(navController)

            AlreadyUserOrNewUser(navController, isNewUser = false)
        }
    }
}

private const val TAG = "RegisterScreen"

@Composable
fun ColumnDivider() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.width(120.dp),
            thickness = 1.5.dp,
            startIndent = 0.dp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = "or continue with")
        Spacer(modifier = Modifier.width(16.dp))
        Divider(
            modifier = Modifier.width(120.dp),
            thickness = 1.5.dp,
            startIndent = 0.dp,
            color = Color.Black
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TakeUserInfo(navController: NavController) {
    val phoneNumber = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val fullName = remember { mutableStateOf("") }

    remember(phoneNumber) {
        mutableStateOf(phoneNumber.value.trim().length == 10)
    }
//    val labelId = stringResource(R.string.enter_phone_number)
    val keyboardController = LocalSoftwareKeyboardController.current
    val (_, getDisplayHeight, _) = AppUtils.screenHeightAndWidth(LocalContext.current)


    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_heading),
            modifier = Modifier,
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_semibold))
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        // taking the full name of the user
        InputField(
            valueState = fullName,
            labelId = "Full Name",
            fieldHeight = getDisplayHeight.dp.times(0.093f),
            capitalization = KeyboardCapitalization.Words,
            onAction = KeyboardActions { keyboardController?.hide() }
        )
        Spacer(modifier = Modifier.height(8.dp))
        // taking email
        InputField(
            valueState = email,
            labelId = "Email",
            keyboardType = KeyboardType.Email,
            fieldHeight = getDisplayHeight.dp.times(0.093f),
            capitalization = KeyboardCapitalization.None,
            onAction = KeyboardActions { keyboardController?.hide() }
        )
        Spacer(modifier = Modifier.height(8.dp))
        // taking phone number
        InputPhoneNumber(
            phoneNumber = phoneNumber,
            height = getDisplayHeight.dp.times(0.093f),
            onAction = KeyboardActions {
                keyboardController?.hide()
            })
        Spacer(modifier = Modifier.height(16.dp))
        SignInAndSignOptions(
            null,
            stringResource(id = R.string.sign_up_lbl),
            bgColor = AppColors.green,
            height = getDisplayHeight.dp.times(0.093f),
            navController = navController,
            onClicked = { navController.navigate(Screens.OTPCodeScreen.route) }
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    fieldHeight: Dp = 62.dp,
    isSingleLine: Boolean = true,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.Sentences,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    var animatedVisibility by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(fieldHeight),
//        shape = RoundedCornerShape(30),
        shape = CircleShape,
        border = BorderStroke(2.dp, color = AppColors.green),

        ) {

        val (_, _, screenArea) = AppUtils.screenHeightAndWidth(LocalContext.current)

        TextField(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 8.dp),
            value = valueState.value,
            onValueChange = {
                valueState.value = it
                animatedVisibility = it.trim().isNotEmpty()
            },
            placeholder = {
                Text(
                    text = labelId, textAlign = TextAlign.Center,
                    style = TextStyle(
                        color = AppColors.green,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                )
            },
            singleLine = isSingleLine,
            textStyle = TextStyle(
                fontSize = 22.sp,
                color = AppColors.green,
                fontFamily = FontFamily(Font(R.font.poppins_regular))
            ),
            keyboardOptions = KeyboardOptions(
                capitalization = capitalization,
                keyboardType = keyboardType,
                imeAction = imeAction,
                autoCorrect = !labelId.contains("Email", ignoreCase = true)
            ),
            keyboardActions = onAction,
            colors = textFieldColors(
                textColor = AppColors.green,
                backgroundColor = Color.White,
            ),
            maxLines = 1,
            shape = CircleShape,
            trailingIcon = {
                AnimatedVisibility(animatedVisibility, enter = fadeIn(), exit = fadeOut()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = "Clear text",
                        modifier = Modifier
                            .size(screenArea.dp.times(0.00008f))
                            .background(color = AppColors.lightLightGreen, shape = CircleShape)
                            .clickable {
                                valueState.value = ""
                                animatedVisibility = false
                            },
                        tint = Color.White
                    )
                }
            }
        )
    }
}


@Composable
fun AlternateSignUpOptions(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        // login with google
        SignInAndSignOptions(
            icon = painterResource(id = R.drawable.google_login),
            bgColor = AppColors.google,
            navController = navController,
        )

        // login with google
        SignInAndSignOptions(
            icon = painterResource(id = R.drawable.facebook_login),
            bgColor = AppColors.facebook,
            navController = navController,
            animationDelayTime = 10
        )

        // login with google
        SignInAndSignOptions(
            icon = painterResource(id = R.drawable.apple_login),
            bgColor = AppColors.apple,
            navController = navController,
        )
    }
}

@Composable
private fun SignInAndSignOptions(
    icon: Painter,
    bgColor: Color,
    navController: NavController,
    animationDelayTime: Int = 0
) {
    val (_, _, screenArea) = AppUtils.screenHeightAndWidth(LocalContext.current)

    val distance = with(LocalDensity.current) { 10.dp.toPx() }
    Log.d(TAG, "SignInAndSignOptions: distance is $distance")
    val circles = remember { Animatable(initialValue = 0f) }

    val circlesValues = circles.value

    LaunchedEffect(key1 = circles, block = {
        delay(animationDelayTime * 50L)
        circles.animateTo(
            targetValue = 1f, animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 1500
                    0.0f at 0 with LinearOutSlowInEasing
                    1.0f at 750 with LinearOutSlowInEasing
                    0.0f at 750 with LinearOutSlowInEasing
//                    0.0f at 0 with LinearOutSlowInEasing
                },
                repeatMode = RepeatMode.Reverse
            )
        )
    })

    Button(
        onClick = { navController.navigate(Screens.OTPCodeScreen.route) },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        modifier = Modifier
            .size(screenArea.dp.times(0.00022f))
            .graphicsLayer {
                translationY = -circlesValues*distance
            },
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = bgColor,
            disabledBackgroundColor = Color.White
        ),
        contentPadding = PaddingValues(4.dp)
    ) {
        Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
    }
}