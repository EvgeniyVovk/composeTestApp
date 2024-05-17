package ru.testapp.main_screen.presentation.reducer

import ru.testapp.main_screen.presentation.action.CoffeeAction
import ru.testapp.main_screen.presentation.model.CoffeePresentation
import ru.testapp.main_screen.presentation.state.CoffeeState
import ru.testapp.utils.Reducer
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class CoffeeReducer @Inject constructor() : Reducer<CoffeeState, CoffeeAction<Any>> {

    override fun reduce(state: CoffeeState, action: CoffeeAction<Any>): CoffeeState {
        return when (action) {
            is CoffeeAction.GetCoffeeList -> {
                state.copy(coffee = action.data as List<CoffeePresentation>)
            }
        }
    }
}