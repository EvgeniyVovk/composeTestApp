package ru.testapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Timer
import java.util.TimerTask

private const val INIT_STRING = ""
private const val START_RANGE = 850
private const val END_RANGE = 950
private const val DELAY = 0L
private const val PERIOD = 1000L
private const val PRECISION = 10.0
private const val DATE_FORMAT = "HH:mm"

class TopBarViewModel : ViewModel() {

    private val timer = Timer()

    private val _currentTime: MutableStateFlow<String> = MutableStateFlow(INIT_STRING)
    val currentTime: StateFlow<String> = _currentTime.asStateFlow()

    private val _currentTemperature: MutableStateFlow<String> = MutableStateFlow(INIT_STRING)
    val currentTemperature: StateFlow<String> = _currentTemperature.asStateFlow()

    init {
        timer.scheduleAtFixedRate(object: TimerTask() {
            override fun run() {
                getCurrentTime()
                getCurrentTemperature()
            }
        }, DELAY, PERIOD)
    }

    private fun getCurrentTime() {
        viewModelScope.launch {
            val currentTime = SimpleDateFormat(DATE_FORMAT, Locale.US).format(Date())
            _currentTime.emit(currentTime)
        }
    }

    private fun getCurrentTemperature() {
        viewModelScope.launch {
            val currentTemperature = (START_RANGE..END_RANGE).random() / PRECISION
            _currentTemperature.emit(currentTemperature.toString())
        }
    }
}