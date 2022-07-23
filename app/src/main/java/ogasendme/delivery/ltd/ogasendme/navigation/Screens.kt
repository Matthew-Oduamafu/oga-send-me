package ogasendme.delivery.ltd.ogasendme.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens(ScreenRoutes.SPLASH.name)
    object LoginScreen : Screens(ScreenRoutes.LOGIN.name)
    object RegisterScreen : Screens(ScreenRoutes.REGISTER.name)
    object WelcomeScreen : Screens(ScreenRoutes.WELCOME.name)
    object OTPCodeScreen : Screens(ScreenRoutes.OTP_CODE.name)
    object HomeScreen : Screens(ScreenRoutes.HOME.name)
    object FoodScreen : Screens(ScreenRoutes.FOOD.name)
    object AnythingScreen : Screens(ScreenRoutes.ANYTHING.name)
    object FashionScreen : Screens(ScreenRoutes.FASHION.name)
    object ElectronicsScreen : Screens(ScreenRoutes.ELECTRONICS.name)
    object PackageDeliveryScreen : Screens(ScreenRoutes.PACKAGE_DELIVERY.name)
    object HealthAndBeautyScreen : Screens(ScreenRoutes.HEALTH_AND_BEAUTY.name)
    object UserProfileScreen : Screens(ScreenRoutes.USER_PROFILE.name)
    object CartScreen : Screens(ScreenRoutes.CART.name)
    object FoodOrProductItemScreen : Screens(ScreenRoutes.FOOD_OR_PRODUCT_ITEM.name)
    object StoreOrShopScreen : Screens(ScreenRoutes.STORE_OR_SHOP.name)
    object SelectedProductDetailsScreen : Screens(ScreenRoutes.SELECTED_FOOD_AND_PROMO.name)
    object CheckOutAndNumberScreen : Screens(ScreenRoutes.CHECK_OUT_AND_NUMBER.name)
    object DropOffOptionsScreen : Screens(ScreenRoutes.DROP_OFF_OPTIONS.name)
    object UserInformationScreen : Screens(ScreenRoutes.USER_INFORMATION.name)
    object DeliveryLocationMapScreen : Screens(ScreenRoutes.DELIVERY_LOCATION_MAP.name)
    object PhoneNumberScreen : Screens(ScreenRoutes.PHONE_NUMBER.name)
    object OrderScreen : Screens(ScreenRoutes.ORDERS.name)
}