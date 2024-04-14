package com.example.duckapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.duckapp.randomduckpage.DuckScreen
import com.example.duckapp.randomduckpage.RandomDuckPageViewModel
import com.example.duckapp.ui.theme.DuckAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DuckAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val duckPageViewModel = hiltViewModel<RandomDuckPageViewModel>()
                    DuckScreen(viewModel = duckPageViewModel)
                }
            }
        }
    }
}