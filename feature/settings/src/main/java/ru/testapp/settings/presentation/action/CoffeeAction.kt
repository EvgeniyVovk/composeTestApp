package ru.testapp.settings.presentation.action

import androidx.annotation.DrawableRes
import ru.testapp.utils.Action

sealed class CoffeeAction<out T: Any> : Action {
    data object FreeOrPaidCoffee: CoffeeAction<Nothing>()
    data class NameChanged(val name: String): CoffeeAction<String>()
    data class PriceChanged(val price: Int): CoffeeAction<Int>()
    data class ImageChanged(@DrawableRes val image: Int): CoffeeAction<Int>()
    data class GetDetailCoffee<out T: Any>(val data: T): CoffeeAction<T>()
}