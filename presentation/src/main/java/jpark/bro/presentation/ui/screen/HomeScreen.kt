package jpark.bro.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Box(modifier = Modifier
        .background(Color.Blue)
    ) {
        Text(text = "Home Screen")
    }
}