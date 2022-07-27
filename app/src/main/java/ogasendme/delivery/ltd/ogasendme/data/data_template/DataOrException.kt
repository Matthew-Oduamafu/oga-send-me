package ogasendme.delivery.ltd.ogasendme.data.data_template

data class DataOrException<T, Boolean, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)
