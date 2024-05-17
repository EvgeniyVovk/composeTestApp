package ru.testapp.main_screen.domain.model

data class CoffeeDomain(
    val image: Int,
    val name: String,
    val price: Int,
    val volume: Double,
    val isFree: Boolean
)
