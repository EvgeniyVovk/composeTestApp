package ru.testapp.settings.presentation.state

import ru.testapp.settings.presentation.model.DetailCoffeePresentation
import ru.testapp.utils.State

data class CoffeeState(
    val coffee: DetailCoffeePresentation
): State