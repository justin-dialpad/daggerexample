package com.example.dagger_example.injection

import com.example.dagger_example.thing_feature.domain.FeatureThingDao
import com.example.dagger_example.thing_feature.domain.FeatureThingsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideThingsRepository(featureThingDao: FeatureThingDao): FeatureThingsRepository = FeatureThingsRepository(featureThingDao)
}