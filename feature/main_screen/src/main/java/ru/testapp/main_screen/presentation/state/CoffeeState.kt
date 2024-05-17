package ru.testapp.main_screen.presentation.state

import ru.testapp.main_screen.presentation.model.CoffeePresentation
import ru.testapp.utils.State

data class CoffeeState(
    val coffee: List<CoffeePresentation>
): State
