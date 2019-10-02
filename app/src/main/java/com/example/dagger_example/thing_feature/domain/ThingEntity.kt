package com.example.dagger_example.thing_feature.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "thing")
data class ThingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val description: String
)