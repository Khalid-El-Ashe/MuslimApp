package com.dev.imuslim

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.dev.imuslim.ui.navigation.NavigationBuilder
import com.dev.imuslim.ui.screens.HomeScreen
import com.dev.imuslim.ui.theme.ImuslimTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false) // this is to change the top app par
        setContent {
            ImuslimTheme {
                val isSystemDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()
//                SideEffect {
//                    systemController.setSystemBarsColor(
//                        color = Color.Transparent, darkIcons = !isSystemDarkMode
//                    )
//                }

                val controller = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavigationBuilder(controller = controller)
                }
            }
        }
    }
}