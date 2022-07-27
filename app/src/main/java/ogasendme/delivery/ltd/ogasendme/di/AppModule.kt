package ogasendme.delivery.ltd.ogasendme.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ogasendme.delivery.ltd.ogasendme.data.database.LocationHistoryDatabase
import ogasendme.delivery.ltd.ogasendme.data.database.LocationHistoryDatabaseDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // creating the database
    @Singleton
    @Provides
    fun provideLocationDatabaseApi(@ApplicationContext context: Context): LocationHistoryDatabase =
        with(
            Room.databaseBuilder(
                context,
                LocationHistoryDatabase::class.java,
                "location_history_db"
            )
        )
        {
            fallbackToDestructiveMigration()
            build()
        }

    // database dao provider
    @Singleton
    @Provides
    fun provideLocationHistoryDatabaseDao(database: LocationHistoryDatabase): LocationHistoryDatabaseDao =
        database.LocationHistoryDao()
}