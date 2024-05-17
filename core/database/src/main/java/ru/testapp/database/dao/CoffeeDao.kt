package ru.testapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.testapp.database.model.CoffeeEntity

@Dao
interface CoffeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upset(coffee: CoffeeEntity): Long

    @Query("SELECT * FROM coffee_table")
    suspend fun getCoffee(): CoffeeEntity?
}