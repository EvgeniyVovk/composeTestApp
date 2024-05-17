package ru.testapp.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coffee_table")
data class CoffeeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: Int,
    val name: String,
    val price: Int,
    val volume: Double,
    val isFree: Boolean
)
