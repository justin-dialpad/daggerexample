package com.example.dagger_example

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_example.thing_feature.presentation.MainViewModel
import com.example.dagger_example.thing_feature.domain.FeatureThingsRepository

class ThingsViewModelFactory(
    private val application: Application,
    private val featureThingsRepository: FeatureThingsRepository
): ViewModelProvider.AndroidViewModelFactory(application) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            application,
            featureThingsRepository
        ) as T
    }
}