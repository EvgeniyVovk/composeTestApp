package ru.testapp.main_screen.domain

import ru.testapp.main_screen.domain.model.CoffeeDomain

interface MainScreenRepository {

    suspend fun getCoffeeFromDb(): CoffeeDomain
}