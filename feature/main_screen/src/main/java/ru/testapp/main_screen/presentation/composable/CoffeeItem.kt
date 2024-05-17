package ru.testapp.main_screen.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.testapp.main_screen.presentation.model.CoffeePresentation
import ru.testapp.ui.composable.DevicesPreview
import ru.testapp.ui.theme.UnicumTestAppTheme
import ru.testapp.ui.R as coreUiR

@Composable
fun CoffeeItem(coffee: CoffeePresentation) {
    Column(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    start = Offset.Zero,
                    end = Offset.Infinite,
                    colors = listOf(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.onSecondary
                    )
                ),
                RoundedCornerShape(6.dp)
            )
            .clip(RoundedCornerShape(6.dp))
            .width(227.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(coffee.image),
            contentDescription = null,
            modifier = Modifier.size(210.dp)
        )
        Text(
            text = coffee.name,
            color = MaterialTheme.colorScheme.primaryContainer,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(34.dp))
        Row(
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.secondaryContainer
                )
                .background(
                    Brush.linearGradient(
                        start = Offset.Zero, end = Offset.Infinite,
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            MaterialTheme.colorScheme.onSurface,
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                )
                .fillMaxWidth()
                .padding(vertical = 9.dp, horizontal = 16.dp),
            horizontalArrangement = if (coffee.isFree) Arrangement.Center else Arrangement.SpaceBetween
        ) {
            Text(
                text = coffee.volume.toString(),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.headlineMedium
            )
            if (!coffee.isFree) {
                Text(
                    text = stringResource(id = coreUiR.string.price, coffee.price),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@DevicesPreview
@Composable
fun CoffeeItemPreview() {
    UnicumTestAppTheme {
        CoffeeItem(
            coffee = CoffeePresentation(
                image = ru.testapp.ui.R.drawable.cappuchino,
                name = stringResource(id = coreUiR.string.default_coffee_name),
                isFree = false,
                price = stringResource(id = coreUiR.string.default_coffee_price).toInt(),
                volume = stringResource(id = coreUiR.string.default_coffee_volume).toDouble()
            )
        )
    }
}