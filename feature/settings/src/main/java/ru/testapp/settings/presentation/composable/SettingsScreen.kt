package ru.testapp.settings.presentation.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.testapp.settings.presentation.viewmodel.SettingsScreenViewModel
import ru.testapp.ui.composable.TopBar
import ru.testapp.ui.R as coreUiR

@DrawableRes
private val cappuccinoImgRes = coreUiR.drawable.cappuchino

@DrawableRes
private val mochaccinoImgRes = coreUiR.drawable.mochaccino

@Composable
fun SettingsScreen(
    onHeaderClicked: () -> Unit
) {
    val viewModel: SettingsScreenViewModel = hiltViewModel()
    val coffee = viewModel.detailCoffee.collectAsState()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopBar {
                onHeaderClicked()
            }
        },
        content = { contentPadding ->
            Box(
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        CoffeeSettings(
                            viewModel = viewModel,
                            onSwitcherClicked = {
                                viewModel.switchedToFreeOrPaid()
                            },
                            onNameChanged = { newName ->
                                viewModel.setNewName(newName)
                            },
                            onPriceChanged = { newPrice ->
                                viewModel.setNewPrice(newPrice)
                            }
                        )

                        Spacer(modifier = Modifier.height(64.dp))

                        val hasChanged = coffee.value == viewModel.state.coffee

                        SaveButton(
                            onClick = {
                                viewModel.updateCoffee(viewModel.state.coffee)
                            },
                            isEnabled = !hasChanged
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    CoffeeImage(
                        coffeeImgRes = cappuccinoImgRes,
                        isSelected = viewModel.state.coffee.image == cappuccinoImgRes
                    ) {
                        viewModel.setNewImage(cappuccinoImgRes)
                    }
                    CoffeeImage(
                        coffeeImgRes = mochaccinoImgRes,
                        isSelected = viewModel.state.coffee.image == mochaccinoImgRes
                    ) {
                        viewModel.setNewImage(mochaccinoImgRes)
                    }
                }
            }
        }
    )
}
