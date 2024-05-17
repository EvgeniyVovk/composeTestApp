package ru.testapp.main_screen.presentation.mapper

import ru.testapp.main_screen.domain.model.CoffeeDomain
import ru.testapp.main_screen.presentation.model.CoffeePresentation
import javax.inject.Inject

class CoffeeDomainToCoffeePresentationMapper @Inject constructor() {

    fun toCoffeePresentation(coffeeDomain: CoffeeDomain): CoffeePresentation {
        return CoffeePresentation(
            image = coffeeDomain.image,
            name = coffeeDomain.name,
            price = coffeeDomain.price,
            volume = coffeeDomain.volume,
            isFree = coffeeDomain.isFree
        )
    }
}