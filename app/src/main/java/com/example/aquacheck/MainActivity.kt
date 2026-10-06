package com.example.aquacheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aquacheck.navigation.AppNavigation
import com.example.aquacheck.ui.theme.AquaCheckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AquaCheckTheme {
                AppNavigation()
            }
        }
    }
}
