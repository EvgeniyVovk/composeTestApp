package ru.testapp.settings.presentation.reducer

import ru.testapp.settings.presentation.action.CoffeeAction
import ru.testapp.settings.presentation.model.DetailCoffeePresentation
import ru.testapp.settings.presentation.state.CoffeeState
import ru.testapp.utils.Reducer
import javax.inject.Inject

class CoffeeReducer @Inject constructor() : Reducer<CoffeeState, CoffeeAction<Any>> {

    override fun reduce(state: CoffeeState, action: CoffeeAction<Any>): CoffeeState {
        return when (action) {
            CoffeeAction.FreeOrPaidCoffee -> state.copy(coffee = state.coffee.copy(isFree = !state.coffee.isFree))
            is CoffeeAction.NameChanged -> {
                state.copy(coffee = state.coffee.copy(name = action.name))
            }

            is CoffeeAction.GetDetailCoffee -> {
                state.copy(coffee = action.data as DetailCoffeePresentation)
            }

            is CoffeeAction.PriceChanged -> {
                state.copy(coffee = state.coffee.copy(price = action.price))
            }

            is CoffeeAction.ImageChanged -> {
                state.copy(coffee = state.coffee.copy(image = action.image))
            }
        }
    }
}