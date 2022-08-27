package ogasendme.delivery.ltd.ogasendme.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ogasendme.delivery.ltd.ogasendme.model.app.LocationDetails


@Dao
interface LocationDatabaseDao {
    @Query(
        """
        SELECT * FROM location_details_tb
    """
    )
    fun getAllLocations():Flow<List<LocationDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocationDetails(locationDetails: LocationDetails)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLocationDetails(locationDetails: LocationDetails)

    @Delete
    suspend fun deleteLocation(locationDetails: LocationDetails)

    @Query(
        """
        DELETE FROM location_details_tb
    """
    )
    suspend fun deleteLocationDetails()
}