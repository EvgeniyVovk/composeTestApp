package ru.testapp.settings.data.mapper

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.testapp.database.model.CoffeeEntity
import ru.testapp.settings.domain.DetailCoffeeDomain
import ru.testapp.ui.R
import javax.inject.Inject

class CoffeeEntityToDetailCoffeeDomainMapper @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun toDetailCoffeeDomain(coffeeEntity: CoffeeEntity?): DetailCoffeeDomain {
        return DetailCoffeeDomain(
            image = coffeeEntity?.image ?: R.drawable.cappuchino,
            name = coffeeEntity?.name ?: context.getString(R.string.default_coffee_name),
            price = coffeeEntity?.price ?: context.getString(R.string.default_coffee_price).toInt(),
            isFree = coffeeEntity?.isFree ?: false
        )
    }

    fun toCoffeeEntity(coffeeDomain: DetailCoffeeDomain): CoffeeEntity {
        return CoffeeEntity(
            id = 0,
            image = coffeeDomain.image,
            name = coffeeDomain.name,
            price = coffeeDomain.price,
            volume = context.getString(R.string.default_coffee_volume).toDouble(),
            isFree = coffeeDomain.isFree
        )
    }
}