package com.example.dagger_example.injection

import com.example.dagger_example.thing_feature.domain.FeatureThingDao
import com.example.dagger_example.thing_feature.domain.ThingsRoomDatabase
import dagger.Module
import dagger.Provides

@Module
class DaoModule {
    @Provides
    fun provideThingsDao(database: ThingsRoomDatabase): FeatureThingDao = database.thingsFeatureDao()
}