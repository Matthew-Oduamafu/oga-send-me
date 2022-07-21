package ogasendme.delivery.ltd.ogasendme.data

data class StoresAround(
    val storeName: String,
    val listOfSaleItems: List<SalesItem>,
    val location: String
)
