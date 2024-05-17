package ru.testapp.main_screen.data

import ru.testapp.database.dao.CoffeeDao
import ru.testapp.main_screen.data.mapper.CoffeeEntityToCoffeeDomainMapper
import ru.testapp.main_screen.domain.MainScreenRepository
import ru.testapp.main_screen.domain.model.CoffeeDomain
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val coffeeDao: CoffeeDao,
    private val mapper: CoffeeEntityToCoffeeDomainMapper
) : MainScreenRepository {

    override suspend fun getCoffeeFromDb(): CoffeeDomain {
        return mapper.toCoffeeDomain(coffeeDao.getCoffee())
    }
}