package ru.testapp.settings.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.testapp.ui.R

@Composable
fun PriceEditText(text: Int, onPriceChanged: (Int) -> Unit) {
    val pattern = remember { Regex("^\\d+\$") }
    BasicTextField(
        value = text.toString(),
        onValueChange = { newText ->
            if (newText.isEmpty() || newText.matches(pattern)) {
                val newPrice = newText.toIntOrNull() ?: 0
                onPriceChanged(newPrice)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceTint, RoundedCornerShape(6.dp))
            .padding(vertical = 16.dp, horizontal = 12.dp),
        textStyle = MaterialTheme.typography.headlineLarge.copy(color = MaterialTheme.colorScheme.tertiaryContainer),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                innerTextField()
                Text(
                    text = stringResource(id = R.string.rub_sign),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.inversePrimary
                )
            }
        }
    )
}