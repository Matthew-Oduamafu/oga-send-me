package ogasendme.delivery.ltd.ogasendme.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ogasendme.delivery.ltd.ogasendme.data.database.LocationDatabase
import ogasendme.delivery.ltd.ogasendme.data.database.LocationDatabaseDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // database dao provider
    @Singleton
    @Provides
    fun provideLocationDatabaseDaoApi(locationDatabase: LocationDatabase): LocationDatabaseDao =
        locationDatabase.locationDatabaseDao()


    // actually creating the database
    @Singleton
    @Provides
    fun provideLocationDatabase(@ApplicationContext context: Context): LocationDatabase = with(
        Room.databaseBuilder(
            context,
            LocationDatabase::class.java,
            "location_database"
        )
    ) {
        fallbackToDestructiveMigration()
        build()
    }
}