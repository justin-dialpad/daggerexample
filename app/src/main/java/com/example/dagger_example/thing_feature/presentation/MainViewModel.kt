package com.example.dagger_example.thing_feature.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.dagger_example.thing_feature.domain.FeatureThingsRepository
import com.example.dagger_example.thing_feature.presentation.FeatureThingForDisplay

class MainViewModel(
    application: Application,
    featureThingsRepository: FeatureThingsRepository
): AndroidViewModel(application) {
    val things: LiveData<PagedList<FeatureThingForDisplay>>

    init {
        val thingFactory = featureThingsRepository.thingDataSourceFactory()
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setInitialLoadSizeHint(50)
            .setPrefetchDistance(10)
            .build()
        things = LivePagedListBuilder(thingFactory, config).build()
    }
}