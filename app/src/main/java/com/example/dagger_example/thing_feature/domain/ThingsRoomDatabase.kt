package com.example.dagger_example.thing_feature.domain

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ThingEntity::class], version = 1, exportSchema = false)
abstract class ThingsRoomDatabase : RoomDatabase() {
    abstract fun thingsFeatureDao(): FeatureThingDao
}