package ru.testapp.main_screen.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.testapp.main_screen.presentation.viewmodel.MainScreenViewModel
import ru.testapp.ui.composable.TopBar
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(onHeaderClicked: () -> Unit) {
    val viewModel: MainScreenViewModel = hiltViewModel()

    LaunchedEffect(viewModel.state.coffee) {
        viewModel.getCoffee()
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopBar { onHeaderClicked() }
        },
        content = { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 227.dp),
                modifier = Modifier.padding(paddingValues),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(viewModel.state.coffee) {
                    CoffeeItem(coffee = it)
                }
            }
        }
    )
}