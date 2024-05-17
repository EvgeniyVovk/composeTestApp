package ru.testapp.settings.data

import ru.testapp.database.dao.CoffeeDao
import ru.testapp.settings.data.mapper.CoffeeEntityToDetailCoffeeDomainMapper
import ru.testapp.settings.domain.DetailCoffeeDomain
import ru.testapp.settings.domain.SettingsScreenRepository
import javax.inject.Inject

class SettingsScreenRepositoryImpl @Inject constructor(
    private val coffeeDao: CoffeeDao,
    private val mapper: CoffeeEntityToDetailCoffeeDomainMapper
) : SettingsScreenRepository {

    override suspend fun getCoffeeFromDb(): DetailCoffeeDomain {
        return mapper.toDetailCoffeeDomain(coffeeDao.getCoffee())
    }

    override suspend fun updateCoffee(coffee: DetailCoffeeDomain): Long {
        return coffeeDao.upset(mapper.toCoffeeEntity(coffee))
    }
}