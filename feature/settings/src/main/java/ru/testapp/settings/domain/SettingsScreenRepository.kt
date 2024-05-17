package ru.testapp.settings.domain

interface SettingsScreenRepository {

    suspend fun getCoffeeFromDb(): DetailCoffeeDomain
    suspend fun updateCoffee(coffee: DetailCoffeeDomain): Long
}