package com.mij.itembox

import HomePage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.NavigationBar
import androidx.navigation.compose.rememberNavController
import com.mij.itembox.ui.theme.ItemBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItemBoxTheme {
                HomePage()
                BottomNavigationBar()
            }
        }
    }
}


