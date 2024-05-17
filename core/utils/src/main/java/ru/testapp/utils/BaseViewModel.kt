package ru.testapp.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel<S : State, A : Action>(
    private val reducer: Reducer<S, A>,
    stateInit: S
) : ViewModel() {

    private val actionFlow = MutableSharedFlow<A>(extraBufferCapacity = 128)

    var state: S by mutableStateOf(stateInit)
        private set

    init {
        viewModelScope.launch {
            actionFlow.collect { action ->
                state = reducer.reduce(state, action)
            }
        }
    }

    fun emit(action: A) {
        actionFlow.tryEmit(action)
    }
}