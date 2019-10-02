package com.example.dagger_example.thing_feature.domain

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FeatureThingDao {
    @Query("SELECT * FROM thing")
    fun allThingsDataSourceFactory(): DataSource.Factory<Int, ThingEntity>

    @Query("DELETE FROM thing")
    fun deleteAll()

    @Insert
    fun insertAll(things: List<ThingEntity>)
}