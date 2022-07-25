package ogasendme.delivery.ltd.ogasendme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ogasendme.delivery.ltd.ogasendme.navigation.OgaSendMeNavigation
import ogasendme.delivery.ltd.ogasendme.ui.theme.OgaSendMeTheme
import ogasendme.delivery.ltd.ogasendme.utils.AppColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OgaSendMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppColors.green
                ) {
                    OgaSendMeNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OgaSendMeTheme {
    }
}