package ru.testapp.settings.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.testapp.settings.R
import ru.testapp.settings.presentation.viewmodel.SettingsScreenViewModel

@Composable
fun CoffeeSettings(
    viewModel: SettingsScreenViewModel,
    onSwitcherClicked: () -> Unit,
    onNameChanged: (String) -> Unit,
    onPriceChanged: (Int) -> Unit
) {
    Column(
        modifier = Modifier.width(418.dp)
    ) {
        HeaderText(text = stringResource(id = R.string.coffee_name))
        Spacer(modifier = Modifier.height(12.dp))
        NameEditText(text = viewModel.state.coffee.name, onNameChanged = onNameChanged)
        Spacer(modifier = Modifier.height(32.dp))
        HeaderText(text = stringResource(id = R.string.price_name))
        PriceEditText(text = viewModel.state.coffee.price, onPriceChanged)
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable { onSwitcherClicked() }
                .padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.free_switcher_name),
                color = MaterialTheme.colorScheme.inversePrimary,
                style = MaterialTheme.typography.headlineMedium
            )
            Switch(
                checked = viewModel.state.coffee.isFree,
                onCheckedChange = { onSwitcherClicked() },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colorScheme.inverseSurface,
                    checkedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    checkedTrackColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    uncheckedBorderColor = MaterialTheme.colorScheme.tertiary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.tertiary,
                    uncheckedTrackColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}

@Composable
private fun HeaderText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primaryContainer,
        style = MaterialTheme.typography.headlineMedium
    )
}