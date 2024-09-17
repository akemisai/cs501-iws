package com.example.iws2_q2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iws2_q2.ui.theme.Iws2q2Theme
import com.example.iws2_q2.ui.theme.Purple40
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Iws2q2Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.EnterName.route) {
                    composable(route = Screen.EnterName.route) { EnterNameScreen(navController) }
                    composable(route = Screen.Greeting.route + "/{text}") { navBackStackEntry ->
                        val name = navBackStackEntry.arguments?.getString("text") ?: "Guest"
                        GreetingScreen(text = name)
                    }
                }
            }
        }
    }
}

// EnterName Screen
@Composable
fun EnterNameScreen(navController: NavController, modifier: Modifier = Modifier) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (horizontalAlignment = Alignment.CenterHorizontally,){
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Enter your name") },
                modifier = Modifier.height(50.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            ElevatedButton(
                onClick = {
                    keyboardController?.hide()
                    navController.navigate(Screen.Greeting.createRoute(text))
                },
            ) {
                Text(text = "Submit")
            }
        }
    }
}

fun getGreeting(): String {
    val time = LocalDateTime.now().hour
    return when (time) {
        in 5..11 -> "Good Morning!"
        in 12..17 -> "Good Afternoon!"
        in 18..22 -> "Good Evening!"
        else -> "Good Night!"
    }
}

// Greeting Screen
@Composable
fun GreetingScreen(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $text! ${getGreeting()}",
            modifier = modifier,
            textAlign = TextAlign.Center,
            color = Purple40
        )
    }
}

sealed class Screen(val route: String) {
    object EnterName : Screen("EnterName")
    object Greeting : Screen("Greeting") {
        fun createRoute(text: String) = "Greeting/$text"
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Iws2q2Theme {
        GreetingScreen("Android")
    }
}