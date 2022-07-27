package ogasendme.delivery.ltd.ogasendme.model.user

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName
import ogasendme.delivery.ltd.ogasendme.data.fake.OrderStatus

data class OrderItem(
    var id: String? = null,

    @get:PropertyName("item_name")
    @set:PropertyName("item_name")
    var itemName: String,

    @get:PropertyName("item_image_url")
    @set:PropertyName("item_image_url")
    var itemImageUrl: String,

    @get:PropertyName("item_id")
    @set:PropertyName("item_id")
    var itemId: String,

    @get:PropertyName("item_description")
    @set:PropertyName("item_description")
    var itemDescription: String,

    @get:PropertyName("item_quantity")
    @set:PropertyName("item_quantity")
    var itemQuantity: Int,

    @get:PropertyName("item_unit_price")
    @set:PropertyName("item_unit_price")
    var itemUnitPrice: Float,

    @get:PropertyName("item_quantity_price")
    @set:PropertyName("item_quantity_price")
    var itemQuantityPrice: Float,

    @get:PropertyName("seller_id")
    @set:PropertyName("seller_id")
    var sellerId: String,

    @get:PropertyName("order_date")
    @set:PropertyName("order_date")
    var orderDate: Timestamp,

    @get:PropertyName("order_status")
    @set:PropertyName("order_status")
    var orderStatus: OrderStatus,

    @get:PropertyName("delivered_date")
    @set:PropertyName("delivered_date")
    var deliveredDate: Timestamp
)
