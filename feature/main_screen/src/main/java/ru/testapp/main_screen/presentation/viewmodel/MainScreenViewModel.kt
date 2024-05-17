package ru.testapp.main_screen.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.testapp.utils.di.IoDispatcher
import ru.testapp.main_screen.domain.MainScreenRepository
import ru.testapp.main_screen.presentation.action.CoffeeAction
import ru.testapp.main_screen.presentation.mapper.CoffeeDomainToCoffeePresentationMapper
import ru.testapp.main_screen.presentation.reducer.CoffeeReducer
import ru.testapp.main_screen.presentation.state.CoffeeState
import ru.testapp.utils.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: MainScreenRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val mapper: CoffeeDomainToCoffeePresentationMapper,
    reducer: CoffeeReducer = CoffeeReducer()
) : BaseViewModel<CoffeeState, CoffeeAction<Any>>(
    reducer = reducer,
    stateInit = CoffeeState(listOf())
) {

    fun getCoffee() {
        viewModelScope.launch {
            val coffee = withContext(ioDispatcher) {
                repository.getCoffeeFromDb()
            }
            emit(CoffeeAction.GetCoffeeList(List(20) {
                mapper.toCoffeePresentation(coffee)
            }))
        }
    }
}