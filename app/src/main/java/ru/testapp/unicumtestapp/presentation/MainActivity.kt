package ru.testapp.unicumtestapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.testapp.navigation.NavHostApp
import ru.testapp.ui.theme.UnicumTestAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnicumTestAppTheme {
                NavHostApp()
            }
        }
    }
}