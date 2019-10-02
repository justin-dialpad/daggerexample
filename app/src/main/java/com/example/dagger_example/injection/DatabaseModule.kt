package com.example.dagger_example.injection

import android.app.Application
import androidx.room.Room
import com.example.dagger_example.thing_feature.domain.ThingsRoomDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun provideDatabase(application: Application): ThingsRoomDatabase {
        return Room.databaseBuilder(
            application,
            ThingsRoomDatabase::class.java,
            "things_and_stuff"
        )
            .build()
    }
}