package ogasendme.delivery.ltd.ogasendme.screens.location

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import ogasendme.delivery.ltd.ogasendme.model.app.LocationDetails
import ogasendme.delivery.ltd.ogasendme.repository.LocationDetailsRepository
import javax.inject.Inject

private const val TAG = "LocationViewModel"

@HiltViewModel
class LocationViewModel @Inject constructor(private val locationDetailsRepository: LocationDetailsRepository) :
    ViewModel() {


    private val _locList = MutableStateFlow<List<LocationDetails>>(emptyList())
    val locList = _locList.asStateFlow()


    init {
        Log.d(TAG, "init: called")
        allLocationEntries()
    }

    private fun allLocationEntries() {
        viewModelScope.launch(Dispatchers.IO) {
            locationDetailsRepository.getLocations().distinctUntilChanged().collect { listOfLocs ->
                if (listOfLocs.isEmpty()) {
                    Log.d(TAG, "init: empty favorites")
                    _locList.value = emptyList()
                } else {
                    _locList.value = listOfLocs
                    Log.d(TAG, "init: fav list is ${locList.value}")
                }
            }
        }
    }

    fun deleteLocationEntry(locationDetails: LocationDetails) =
        viewModelScope.launch(Dispatchers.IO) {
            locationDetailsRepository.deleteLocationEntry(locationDetails)
        }

    fun clearLocationHistory() = viewModelScope.launch(Dispatchers.IO) {
        locationDetailsRepository.clearLocationHistory().run {
            allLocationEntries()
        }
    }

    fun updateLocationDetails(locationDetails: LocationDetails) =
        viewModelScope.launch(Dispatchers.IO) {
            locationDetailsRepository.updateLocationInfo(locationDetails)
        }

    fun addNewLocationEntry(locationDetails: LocationDetails) =
        viewModelScope.launch(Dispatchers.IO) {
            locationDetailsRepository.insertLocation(locationDetails)
        }
}