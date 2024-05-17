package ru.testapp.settings.presentation.mapper

import ru.testapp.settings.domain.DetailCoffeeDomain
import ru.testapp.settings.presentation.model.DetailCoffeePresentation
import javax.inject.Inject

class DetailCoffeeDomainToDetailCoffeePresentation @Inject constructor() {

    fun toDetailCoffeePresentation(detailCoffeeDomain: DetailCoffeeDomain): DetailCoffeePresentation {
        return DetailCoffeePresentation(
            image = detailCoffeeDomain.image,
            name = detailCoffeeDomain.name,
            price = detailCoffeeDomain.price,
            isFree = detailCoffeeDomain.isFree
        )
    }

    fun toDetailCoffeeDomain(detailCoffeePresentation: DetailCoffeePresentation): DetailCoffeeDomain {
        return DetailCoffeeDomain(
            image = detailCoffeePresentation.image,
            name = detailCoffeePresentation.name,
            price = detailCoffeePresentation.price,
            isFree = detailCoffeePresentation.isFree
        )
    }
}