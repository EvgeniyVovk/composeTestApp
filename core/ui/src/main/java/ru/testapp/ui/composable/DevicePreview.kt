package ru.testapp.ui.composable

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Phone",
    group = "Devices",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class PhonePreview

@Preview(
    name = "Tablet",
    group = "Devices",
    showSystemUi = true,
    showBackground = true,
    widthDp = 1280,
    heightDp = 800,
    device = Devices.TABLET,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class TabletPreview

@PhonePreview
@TabletPreview
annotation class DevicesPreview