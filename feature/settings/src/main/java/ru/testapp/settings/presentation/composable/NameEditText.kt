package ru.testapp.settings.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NameEditText(text: String, onNameChanged: (String) -> Unit) {
    BasicTextField(
        value = text,
        onValueChange = { newName ->
            onNameChanged(newName)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceTint, RoundedCornerShape(6.dp))
            .padding(vertical = 16.dp, horizontal = 12.dp),
        textStyle = MaterialTheme.typography.headlineLarge.copy(color = MaterialTheme.colorScheme.tertiaryContainer),
        decorationBox = { innerTextField ->
            innerTextField()
        }
    )
}