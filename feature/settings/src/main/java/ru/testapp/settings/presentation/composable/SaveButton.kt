package ru.testapp.settings.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.testapp.settings.R
import ru.testapp.ui.composable.DevicesPreview
import ru.testapp.ui.theme.UnicumTestAppTheme

@Composable
fun SaveButton(onClick: () -> Unit, isEnabled: Boolean) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.tertiary
        ),
        modifier = Modifier.background(
            if (isEnabled) {
                MaterialTheme.colorScheme.onSecondaryContainer
            } else {
                MaterialTheme.colorScheme.tertiary
            },
            RoundedCornerShape(12.dp)
        ),
        enabled = isEnabled
    ) {
        Text(
            text = stringResource(id = R.string.save_button_text),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiaryContainer
        )
    }
}

@DevicesPreview
@Composable
fun SaveButtonPreview() {
    UnicumTestAppTheme {
        SaveButton(onClick = {}, isEnabled = true)
    }
}