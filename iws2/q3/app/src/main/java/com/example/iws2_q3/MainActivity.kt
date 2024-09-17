package com.example.iws2_q3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.iws2_q3.ui.theme.Iws2q3Theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Iws2q3Theme {
                Box (
                    modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                ){
                    ChangeQuote()
                }
            }
        }
    }
}

@Composable
fun ChangeQuote() {
    val list = listOf(
        "Australia is wider than the moon",
        "Avocados are not vegetables",
        "Flamingos aren't born pink",
        "People don't sneeze in their sleep",
        "The shortest war in history lasted 38 minutes",
        "The unicorn is the national animal of Scotland",
        "The first oranges weren't orange",
        "The moon has moonquakes",
        "Dolphins name each other",
        "The real name for a hashtag is an octothorpe",
        "Neil Armstrong's hair was sold in 2004 for \$3,000",
        "The longest English word is 189,819 letters long",
        "People once ate arsenic to improve their skin",
        "The First Recorded Recipe is Over 4,000 Years Old",
        "The Mona Lisa has no eyebrows",
        "The strongest muscle in the body is the tongue",
        "\"I Am\" is the shortest complete sentence in the English language",
        "Coca-Cola was originally green",
        "Camels have three eyelids to protect themselves from the blowing desert sand",
        "Women blink nearly twice as much as men!"
    )
    var text by remember { mutableStateOf(list.random()) }
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
            ElevatedButton(
                onClick = { text = list.random() },
                modifier = Modifier
                    .padding(16.dp)
                    .border(1.dp, Color.White, RoundedCornerShape(16.dp)),
                colors = androidx.compose.material3.ButtonDefaults.elevatedButtonColors(
                    containerColor = Color.Transparent,
                )
            ) {
                Text("Next Fact")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Iws2q3Theme {
        ChangeQuote()
    }
}