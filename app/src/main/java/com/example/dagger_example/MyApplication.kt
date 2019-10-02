package com.example.dagger_example

import com.example.dagger_example.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<MyApplication> =
        DaggerApplicationComponent.builder().application(this).build()
}