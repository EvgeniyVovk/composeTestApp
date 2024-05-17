package ru.testapp.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.testapp.ui.R
import ru.testapp.ui.theme.UnicumTestAppTheme
import ru.testapp.ui.viewmodel.TopBarViewModel

@Composable
fun TopBar(onHeaderClicked: () -> Unit) {
    val viewModel: TopBarViewModel = viewModel()
    val time = viewModel.currentTime.collectAsState()
    val temperature = viewModel.currentTemperature.collectAsState()

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.clickable { onHeaderClicked() }
            ) {
                Image(painter = painterResource(R.drawable.ic_unicum), contentDescription = null)
                Text(
                    stringResource(id = R.string.header_name),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                HeaderBox {
                    HeaderText(text = time.value)
                }
                VerticalDivider()
                HeaderBox {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        HeaderText(
                            text = stringResource(
                                id = R.string.current_temperature,
                                temperature.value
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_temperature),
                            contentDescription = null
                        )
                    }
                }
                VerticalDivider()
                HeaderBox {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = null,
                            modifier = Modifier.size(11.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        HeaderText(text = stringResource(id = R.string.lang))
                    }
                }
            }
        }
        Divider(
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .alpha(0.5f)
        )
    }
}

@Composable
private fun VerticalDivider() {
    Divider(
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .width(1.dp)
            .fillMaxHeight()
            .alpha(0.5f)
    )
}

@Composable
private fun HeaderBox(composable: @Composable () -> Unit) {
    Box(
        modifier = Modifier.width(52.dp),
        contentAlignment = Alignment.Center
    ) {
        composable()
    }
}

@Composable
private fun HeaderText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.inversePrimary,
        style = MaterialTheme.typography.headlineMedium
    )
}

@DevicesPreview
@Composable
fun TopBarPreview() {
    UnicumTestAppTheme {
        TopBar(onHeaderClicked = {})
    }
}