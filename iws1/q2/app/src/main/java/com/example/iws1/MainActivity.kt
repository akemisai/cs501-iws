package com.example.iws1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.iws1.ui.theme.Iws1Theme
import androidx.compose.material3.ElevatedButton
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Iws1Theme {
                val navController = rememberNavController()
                // NavHost
                NavHost(navController = navController, startDestination = Screen.Button.route) {
                    composable(route = Screen.Button.route) { ButtonScreen(navController) }
                    composable(route = Screen.Greeting.route){ GreetingScreen(name = "World") }
                }
            }
        }
    }
}

// Button screen
@Composable
fun ButtonScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            ElevatedButton(
                onClick = { navController.navigate(Screen.Greeting.route) },
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                Text("Click")
            }
        }
    }
}

@Composable
fun GreetingScreen(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Hello, $name",
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(innerPadding)
            )

        }
    }
}


sealed class Screen(val route: String) {
    object Button : Screen("Button")
    object Greeting : Screen("Greeting")
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Iws1Theme {
        GreetingScreen("World")
    }
}
