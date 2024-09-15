package com.example.iws2_q1

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.iws2_q1.ui.theme.Iws2q1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Iws2q1Theme {
                    ChangeQuote()
            }
        }
    }
}

@Composable
fun ChangeQuote() {
    var text by remember { mutableStateOf("Just one small positive thought in the morning can change your whole day") }
    val list = listOf(
        "Just one small positive thought in the morning can change your whole day",
        "Opportunities don't happen, you create them",
        "Don't let someone else's opinion of you become your reality",
        "I have not failed. I've just found 10,000 ways that won't work"
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                modifier = Modifier.height(50.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            ElevatedButton(onClick = {
                text = list.random()
            }) {
                Text("Change Quote")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Iws2q1Theme {
        ChangeQuote()
    }
}