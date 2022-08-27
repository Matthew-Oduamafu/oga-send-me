package ogasendme.delivery.ltd.ogasendme.repository

import kotlinx.coroutines.flow.Flow
import ogasendme.delivery.ltd.ogasendme.data.database.LocationDatabaseDao
import ogasendme.delivery.ltd.ogasendme.model.app.LocationDetails
import javax.inject.Inject

class LocationDetailsRepository @Inject constructor(private val locationDatabaseDao: LocationDatabaseDao) {
    fun getLocations(): Flow<List<LocationDetails>> = locationDatabaseDao.getAllLocations()

    suspend fun insertLocation(locationDetails: LocationDetails) =
        locationDatabaseDao.insertLocationDetails(locationDetails)

    suspend fun clearLocationHistory() = locationDatabaseDao.deleteLocationDetails()

    suspend fun updateLocationInfo(locationDetails: LocationDetails) =
        locationDatabaseDao.updateLocationDetails(locationDetails)

    suspend fun deleteLocationEntry(locationDetails: LocationDetails) =
        locationDatabaseDao.deleteLocation(locationDetails)
}