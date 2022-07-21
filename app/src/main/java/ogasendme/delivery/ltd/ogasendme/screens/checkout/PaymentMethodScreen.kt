package ogasendme.delivery.ltd.ogasendme.screens.checkout

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.utils.AppUtils


@Composable
fun PaymentOptionPopup(showPopup: MutableState<Boolean>) {
    val (_, getDisplayHeight, _) = AppUtils.screenHeightAndWidth(LocalContext.current)
    val animatedVisibility by remember { showPopup }

    if (showPopup.value) {
        Dialog(
            onDismissRequest = { showPopup.value = false }, properties = DialogProperties(
                dismissOnClickOutside = true,
                dismissOnBackPress = true
            )
        ) {
            AnimatedVisibility(
                animatedVisibility,
                enter = slideIn(tween(500, easing = LinearOutSlowInEasing)) { fullSize ->
                    IntOffset(fullSize.width / 4, 100)
                },
                exit = slideOut(tween(200, easing = FastOutSlowInEasing)) {
                    IntOffset(-180, 50)
                }
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(getDisplayHeight.dp.times(0.35f))
                        .padding(top = 12.dp, end = 12.dp),
                    color = Color.White,
                    shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.choose_payment_mthd),
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        )

                        PaymentOptions(icon = R.drawable.momo, text = "Mobile Money")
                        PaymentOptions(icon = R.drawable.cash, text = "Pay with cash")

                        Divider(
                            thickness = 1.5.dp, color = Color.Gray.copy(0.67f), modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                        )
                        PaymentOptions(icon = R.drawable.credit_card, text = "Add new card")
                    }
                }
            }
        }
    }

}

@Composable
fun PaymentOptions(icon: Int, text: String) {
    val (_, getDisplayHeight, _) = AppUtils.screenHeightAndWidth(LocalContext.current)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(getDisplayHeight.dp.times(0.085f))
            .padding(start = 16.dp, end = 16.dp)
            .clickable { },
        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.23f)
                .clickable { },
            contentScale = ContentScale.FillBounds
        )

        Spacer(modifier = Modifier.width(32.dp))

        Text(
            text = text, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 18.sp,
                textAlign = TextAlign.Left
            )
        )
    }
}
