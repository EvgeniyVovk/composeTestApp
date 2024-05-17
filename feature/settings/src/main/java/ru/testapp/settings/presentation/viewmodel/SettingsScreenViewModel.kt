package ru.testapp.settings.presentation.viewmodel

import androidx.annotation.DrawableRes
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.testapp.settings.domain.SettingsScreenRepository
import ru.testapp.settings.presentation.action.CoffeeAction
import ru.testapp.settings.presentation.mapper.DetailCoffeeDomainToDetailCoffeePresentation
import ru.testapp.settings.presentation.model.DetailCoffeePresentation
import ru.testapp.settings.presentation.reducer.CoffeeReducer
import ru.testapp.settings.presentation.state.CoffeeState
import ru.testapp.utils.BaseViewModel
import ru.testapp.utils.di.IoDispatcher
import javax.inject.Inject
import ru.testapp.ui.R as coreUiR

private const val INIT_COFFEE_NAME = "Кофе амаретто"
@DrawableRes
private val INIT_COFFEE_IMAGE = coreUiR.drawable.cappuchino
private const val INIT_COFFEE_PRICE = 199
private const val INIT_IS_FREE = false

object InitCoffeeItem {

    fun initCoffee(): DetailCoffeePresentation {
        return DetailCoffeePresentation(
            image = INIT_COFFEE_IMAGE,
            name = INIT_COFFEE_NAME,
            price = INIT_COFFEE_PRICE,
            isFree = INIT_IS_FREE
        )
    }
}

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val repository: SettingsScreenRepository,
    private val mapper: DetailCoffeeDomainToDetailCoffeePresentation,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    reducer: CoffeeReducer = CoffeeReducer()
) : BaseViewModel<CoffeeState, CoffeeAction<Any>>(
    reducer = reducer,
    stateInit = CoffeeState(InitCoffeeItem.initCoffee())
) {

    private val _detailCoffee: MutableStateFlow<DetailCoffeePresentation> =
        MutableStateFlow(InitCoffeeItem.initCoffee())
    val detailCoffee: StateFlow<DetailCoffeePresentation> = _detailCoffee.asStateFlow()

    init {
        getCoffee()
    }

    private fun getCoffee() {
        viewModelScope.launch {
            val coffee = withContext(ioDispatcher) {
                repository.getCoffeeFromDb()
            }
            val detailCoffeePresentation = mapper.toDetailCoffeePresentation(coffee)
            _detailCoffee.emit(detailCoffeePresentation)
            emit(CoffeeAction.GetDetailCoffee(detailCoffeePresentation))
        }
    }

    fun updateCoffee(coffee: DetailCoffeePresentation) {
        viewModelScope.launch {
            val status = withContext(ioDispatcher) {
                repository.updateCoffee(mapper.toDetailCoffeeDomain(coffee))
            }
            _detailCoffee.emit(coffee)
        }
    }

    fun switchedToFreeOrPaid() {
        emit(CoffeeAction.FreeOrPaidCoffee)
    }

    fun setNewName(newName: String) {
        emit(CoffeeAction.NameChanged(newName))
    }

    fun setNewPrice(newPrice: Int) {
        emit(CoffeeAction.PriceChanged(newPrice))
    }

    fun setNewImage(@DrawableRes newImage: Int) {
        emit(CoffeeAction.ImageChanged(newImage))
    }
}