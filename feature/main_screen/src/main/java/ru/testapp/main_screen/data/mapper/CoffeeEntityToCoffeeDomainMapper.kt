package ru.testapp.main_screen.data.mapper

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.testapp.database.model.CoffeeEntity
import ru.testapp.main_screen.domain.model.CoffeeDomain
import javax.inject.Inject
import ru.testapp.ui.R as coreUiR

class CoffeeEntityToCoffeeDomainMapper @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun toCoffeeDomain(coffeeEntity: CoffeeEntity?): CoffeeDomain {
        return CoffeeDomain(
            image = coffeeEntity?.image ?: coreUiR.drawable.cappuchino,
            name = coffeeEntity?.name ?: context.getString(coreUiR.string.default_coffee_name),
            price = coffeeEntity?.price ?: context.getString(coreUiR.string.default_coffee_price).toInt(),
            volume = coffeeEntity?.volume ?: context.getString(coreUiR.string.default_coffee_volume).toDouble(),
            isFree = coffeeEntity?.isFree ?: false
        )
    }
}