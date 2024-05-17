package ru.testapp.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.testapp.database.CoffeeDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideCoffeeDao(db: CoffeeDatabase) = db.getDao()

    @Provides
    @Singleton
    fun provideCoffeeDatabase(@ApplicationContext context: Context): CoffeeDatabase {
        return Room.databaseBuilder(context, CoffeeDatabase::class.java, "coffee_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}