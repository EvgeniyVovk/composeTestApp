package ru.testapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.testapp.database.dao.CoffeeDao
import ru.testapp.database.model.CoffeeEntity

@Database(
    entities = [CoffeeEntity::class],
    version = 1
)
abstract class CoffeeDatabase: RoomDatabase() {

    abstract fun getDao(): CoffeeDao
}