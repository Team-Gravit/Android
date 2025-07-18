package com.example.gravit.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.gravit.R


@Composable
fun SplashScreen(navController: NavController) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val widthPx = constraints.maxWidth.toFloat()
        val heightPx = constraints.maxHeight.toFloat()

        val gradient = Brush.linearGradient(
            colors = listOf(Color(0xFF8100B3), Color(0xFFDD00FF)),
            start = Offset(0f, heightPx),
            end = Offset(widthPx, 0f)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash_gravit_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp)
            )
        }

        LaunchedEffect(Unit) {
            delay(2000)
            navController.navigate("login_choice") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}

