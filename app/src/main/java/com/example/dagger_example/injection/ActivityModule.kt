package com.example.dagger_example.injection

import com.example.dagger_example.thing_feature.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(
        modules = [
            RepositoryModule::class,
            DaoModule::class,
            DatabaseModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}