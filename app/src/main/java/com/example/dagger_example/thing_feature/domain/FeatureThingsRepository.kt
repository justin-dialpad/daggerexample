package com.example.dagger_example.thing_feature.domain

import androidx.paging.DataSource
import com.example.dagger_example.thing_feature.presentation.FeatureThingForDisplay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

private const val ROOM_AUTO_GENERATE = 0

class FeatureThingsRepository(featureThingDao: FeatureThingDao) : CoroutineScope by MainScope() {
    private var things: DataSource.Factory<Int, FeatureThingForDisplay>

    init {
        launch(Dispatchers.IO) {
            featureThingDao.deleteAll()
            featureThingDao.insertAll(
                listOf(
                    ThingEntity(ROOM_AUTO_GENERATE, "fake full description"),
                    ThingEntity(ROOM_AUTO_GENERATE, "fake full description again"),
                    ThingEntity(ROOM_AUTO_GENERATE, "blah blah blah blah blah")
                )
            )
        }

        things = featureThingDao.allThingsDataSourceFactory().map {
            // Our repository will convert the entities to reduced items we want to use for
            // display so that we aren't dealing with entities directly.
            FeatureThingForDisplay(processDescription(it.description))
        }
    }

    private fun processDescription(fullDescription: String) = "forDisplay: $fullDescription"

    fun thingDataSourceFactory() = things
}