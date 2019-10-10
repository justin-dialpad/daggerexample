package com.example.dagger_example

import com.example.dagger_example.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    private val applicationComponent = DaggerApplicationComponent
        .builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<MyApplication> = applicationComponent
}