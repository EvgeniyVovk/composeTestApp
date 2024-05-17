package ru.testapp.settings.presentation.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.testapp.settings.R
import ru.testapp.ui.composable.DevicesPreview
import ru.testapp.ui.theme.UnicumTestAppTheme
import ru.testapp.ui.R as coreUiR

@Composable
fun CoffeeImage(@DrawableRes coffeeImgRes: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = coffeeImgRes),
            contentDescription = null,
            modifier = Modifier
                .size(227.dp)
                .alpha(if (isSelected) 1f else 0.5f)
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = (-32).dp)
                    .size(32.dp)
                    .background(MaterialTheme.colorScheme.onSecondaryContainer, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_select),
                    contentDescription = null
                )
            }
        }
    }
}

@DevicesPreview
@Composable
fun CoffeeImagePreview() {
    UnicumTestAppTheme {
        CoffeeImage(coffeeImgRes = coreUiR.drawable.cappuchino, isSelected = true, onClick = {})
    }
}