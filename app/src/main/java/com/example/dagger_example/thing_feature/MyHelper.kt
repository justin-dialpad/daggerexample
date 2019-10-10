package com.example.dagger_example.thing_feature

import javax.inject.Inject

class MyHelper @Inject constructor() {
    fun doThing() {
        println("hello, world")
    }
}