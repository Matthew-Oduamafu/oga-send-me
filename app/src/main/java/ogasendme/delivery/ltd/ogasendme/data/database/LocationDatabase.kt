package ogasendme.delivery.ltd.ogasendme.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ogasendme.delivery.ltd.ogasendme.model.app.LocationDetails


@Database(entities = [LocationDetails::class], version = 1, exportSchema = false)
abstract class LocationDatabase: RoomDatabase() {
    abstract fun locationDatabaseDao(): LocationDatabaseDao
}