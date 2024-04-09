package com.example.duckapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.example.duckapp.randomduckpage.DuckScreen
import com.example.duckapp.randomduckpage.RandomDuckPageViewModel
import com.example.duckapp.ui.theme.DuckAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: RandomDuckPageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuckAppTheme {
                Surface {
                    DuckScreen(viewModel = viewModel)
                }
            }
        }
    }
}