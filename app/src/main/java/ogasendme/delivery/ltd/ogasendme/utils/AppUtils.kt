package ogasendme.delivery.ltd.ogasendme.utils

import android.content.Context

object AppUtils {
    internal fun screenHeightAndWidth(context: Context): Triple<Float, Float, Float> {
        val displayMetrics = context.resources.displayMetrics
        val x = displayMetrics.widthPixels / displayMetrics.density
        val y = displayMetrics.heightPixels / displayMetrics.density

        return Triple(
            x,
            y,
            x*y
        )
    }
}