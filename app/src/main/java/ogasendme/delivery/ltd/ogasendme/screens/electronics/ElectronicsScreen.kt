package ogasendme.delivery.ltd.ogasendme.screens.electronics

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ogasendme.delivery.ltd.ogasendme.R
import ogasendme.delivery.ltd.ogasendme.data.fake_data_electronics
import ogasendme.delivery.ltd.ogasendme.navigation.Screens
import ogasendme.delivery.ltd.ogasendme.screens.food.ItemOrProductCard
import ogasendme.delivery.ltd.ogasendme.screens.food.OgaTopAppBar
import ogasendme.delivery.ltd.ogasendme.screens.food.SearchBox
import ogasendme.delivery.ltd.ogasendme.screens.food.searchItem
import ogasendme.delivery.ltd.ogasendme.utils.AppColors

private const val TAG = "ElectronicsScreen"


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ElectronicsScreen(navController: NavController) {
    Log.d(TAG, "ElectronicsScreen: called")

    val state = rememberLazyListState()


    Scaffold(
        topBar = {
            OgaTopAppBar(
                title = stringResource(id = R.string.electronics_screen_lbl),
                bgColor = Color.White,
                iconBgColor = AppColors.green,
                icon = painterResource(id = R.drawable.ic_close),
                elevation = 0.dp,
                navController = navController,
                isCart = true,
                iconClicked = {navController.popBackStack()},
                onCartOrHelpIcon = {navController.navigate(Screens.CartScreen.route)}
            )
        }
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // search box
                SearchBox(label = stringResource(id = R.string.place_or_product_lbl), onSearch = {
                    Log.d(TAG, "ElectronicsScreen: search query is $it")
                    searchItem(it)
                })

                Spacer(modifier = Modifier.height(16.dp))

                // food items available
                LazyColumn(
                    contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp),
                    state = state,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    items(items = fake_data_electronics) { item ->
                        ItemOrProductCard(item = item, isFood = false) {
                            Log.d(TAG, "ElectronicsScreen: item ${item.itemImage} clicked")
                            navController.navigate(Screens.StoreOrShopScreen.route)
                        }
                    }
                }
            }
        }
    }
}