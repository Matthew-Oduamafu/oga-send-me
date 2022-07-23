package ogasendme.delivery.ltd.ogasendme.data

data class OrderItemInfo(
    val item: SalesItem,
    val store: StoresAround,
    val quantity:Int,
    val orderStatus:OrderStatus
)

enum class OrderStatus{
    CONFIRMED,
    PENDING,
    DISPATCHED,
    DELIVERED
}