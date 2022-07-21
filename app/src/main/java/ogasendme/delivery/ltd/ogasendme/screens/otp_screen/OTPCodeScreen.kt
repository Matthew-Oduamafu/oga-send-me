package ogasendme.delivery.ltd.ogasendme.screens.otp_screen

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.navigation.Screens
import ogasendme.delivery.ltd.ogasendme.utils.AppColors

private const val TAG = "OTPCodeScreen"


@Composable
fun OTPCodeScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = stringResource(id = R.string.otp_code_lbl),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(30.dp))

            OTPCodeInputFilled {
                Log.d(TAG, "OTPCodeScreen: full code $it")
//                navController.navigate(Screens.WelcomeScreen.route)
            }



            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.didnt_get_code_lbl), style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = stringResource(id = R.string.resend_code_lbl), style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium))
                    ),
                    modifier = Modifier.clickable { /*TODO*/ },
                    color = AppColors.clickableTextColor
                )
            }
            //TODO delete this and modify OTPCodeInputFilled above
            Button(onClick = { navController.navigate(Screens.WelcomeScreen.route) }) {
                Text("Next")
            }
        }
//        Spacer(modifier = Modifier.height(120.dp))
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OTPCodeInputFilled(onCodeComplete: (String) -> Unit) {
    val fullOtpCode = rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    val otpCode1 = remember { mutableStateOf("") }
    val valid1 = remember(otpCode1) {
        mutableStateOf(otpCode1.value.trim().isNotEmpty())
    }
    val otpCode2 = remember { mutableStateOf("") }
    val valid2 = remember(otpCode2) {
        mutableStateOf(otpCode2.value.trim().isNotEmpty())
    }
    val otpCode3 = remember { mutableStateOf("") }
    val valid3 = remember(otpCode3) {
        mutableStateOf(otpCode3.value.trim().isNotEmpty())
    }
    val otpCode4 = remember { mutableStateOf("") }
    val valid4 = remember(otpCode4) {
        mutableStateOf(otpCode4.value.trim().isNotEmpty())
    }
    val otpCode5 = remember { mutableStateOf("") }
    val valid5 = remember(otpCode5) {
        mutableStateOf(otpCode5.value.trim().isNotEmpty())
    }


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CircleTextField(
            modifier = Modifier,
            valueState = otpCode1,
            fieldHeight = 62.dp,
            fieldWidth = 62.dp,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
            onAction = KeyboardActions {
                if (!valid1.value) return@KeyboardActions

                Log.d(TAG, "OTPCodeInputFilled: code is ${otpCode1.value}")
                fullOtpCode.value += otpCode1.value

                Log.d(TAG, "TakeOneCode: full code is ${fullOtpCode.value}")
                keyboardController?.hide()

            }
        )

        CircleTextField(
            modifier = Modifier,
            valueState = otpCode2,
            fieldHeight = 62.dp,
            fieldWidth = 62.dp,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
            onAction = KeyboardActions {
                if (!valid2.value) return@KeyboardActions

                Log.d(TAG, "OTPCodeInputFilled: code is ${otpCode2.value}")
                fullOtpCode.value += otpCode2.value

                Log.d(TAG, "TakeOneCode: full code is ${fullOtpCode.value}")
                keyboardController?.hide()

            }
        )

        CircleTextField(
            modifier = Modifier,
            valueState = otpCode3,
            fieldHeight = 62.dp,
            fieldWidth = 62.dp,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
            onAction = KeyboardActions {
                if (!valid3.value) return@KeyboardActions

                Log.d(TAG, "OTPCodeInputFilled: code is ${otpCode3.value}")
                fullOtpCode.value += otpCode3.value

                Log.d(TAG, "TakeOneCode: full code is ${fullOtpCode.value}")
                keyboardController?.hide()

            }
        )

        CircleTextField(
            modifier = Modifier,
            valueState = otpCode4,
            fieldHeight = 62.dp,
            fieldWidth = 62.dp,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
            onAction = KeyboardActions {
                if (!valid4.value) return@KeyboardActions

                Log.d(TAG, "OTPCodeInputFilled: code is ${otpCode4.value}")
                fullOtpCode.value += otpCode4.value

                Log.d(TAG, "TakeOneCode: full code is ${fullOtpCode.value}")
                keyboardController?.hide()

            }
        )

        CircleTextField(
            modifier = Modifier,
            valueState = otpCode5,
            fieldHeight = 62.dp,
            fieldWidth = 62.dp,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
            onAction = KeyboardActions {
                if (!valid5.value) return@KeyboardActions

                Log.d(TAG, "OTPCodeInputFilled: code is ${otpCode5.value}")
                fullOtpCode.value += otpCode5.value

                Log.d(TAG, "TakeOneCode: full code is ${fullOtpCode.value}")
                keyboardController?.hide()

            }
        )
    }
    onCodeComplete(fullOtpCode.value.ifEmpty { "Empty" })


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CircleTextField(
    modifier: Modifier,
    valueState: MutableState<String>,
    fieldHeight: Dp = 62.dp,
    fieldWidth: Dp = 62.dp,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        modifier = modifier
            .height(fieldHeight)
            .width(fieldWidth)
            .border(width = 3.dp, color = Color.Gray, shape = CircleShape),
        value = valueState.value,
        onValueChange = {
            if (valueState.value.trim().isEmpty()) {
                valueState.value = it
                Log.d(TAG, "CircleTextField: value just entered ${valueState.value}")
            }
        },
        singleLine = true,
        enabled = false,
        textStyle = TextStyle(
            fontSize = 20.sp,
            color = Color.Gray,
            fontFamily = FontFamily(Font(R.font.poppins_regular)),
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            keyboardType = keyboardType,
            imeAction = imeAction,
            autoCorrect = true
        ),
        keyboardActions = onAction,
        colors = ExposedDropdownMenuDefaults.textFieldColors(
            textColor = Color.Gray,
            backgroundColor = Color.White,
            cursorColor = Color.LightGray,
            focusedIndicatorColor = Color.LightGray,
            unfocusedIndicatorColor = Color.LightGray
        ),
        shape = CircleShape
    )
}

