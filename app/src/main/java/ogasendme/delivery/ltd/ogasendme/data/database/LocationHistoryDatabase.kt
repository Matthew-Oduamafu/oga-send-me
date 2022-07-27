package ogasendme.delivery.ltd.ogasendme.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ogasendme.delivery.ltd.ogasendme.model.app.LocationHistory


@Database(entities = [LocationHistory::class], version = 1, exportSchema = false)
abstract class LocationHistoryDatabase:RoomDatabase() {
    abstract fun LocationHistoryDao():LocationHistoryDatabaseDao


}