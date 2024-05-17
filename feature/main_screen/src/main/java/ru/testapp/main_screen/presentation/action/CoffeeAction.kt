package ru.testapp.main_screen.presentation.action

import ru.testapp.utils.Action

sealed class CoffeeAction<out T: Any> : Action {
    data class GetCoffeeList<out T: Any>(val data: T): CoffeeAction<T>()
}