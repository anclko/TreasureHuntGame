package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    captainGame()
                }
            }
        }
    }

    @Composable
    fun captainGame() {
        val treasuresFound = remember { mutableStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormChance = 0.2
        val stormMessage = remember { mutableStateOf("") }

        Column {
            Text("Treasures Found: ${treasuresFound.value}")
            Text("Current Direction: ${direction.value}")

            //storm message if present
            if (stormMessage.value.isNotEmpty()) {
                Text(stormMessage.value)
            }

            Button(onClick = {
                direction.value = "East"
                if (Random.nextFloat() < stormChance) {
                    //if storm, reset treasures and show message
                    treasuresFound.value = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound.value += 1
                    }
                }
            }) {
                Text("Sail East")
            }

            Button(onClick = {
                direction.value = "West"
                if (Random.nextFloat() < stormChance) {
                    treasuresFound.value = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound.value += 1
                    }
                }
            }) {
                Text("Sail West")
            }

            Button(onClick = {
                direction.value = "North"
                if (Random.nextFloat() < stormChance) {
                    treasuresFound.value = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound.value += 1
                    }
                }
            }) {
                Text("Sail North")
            }

            Button(onClick = {
                direction.value = "South"
                if (Random.nextFloat() < stormChance) {
                    treasuresFound.value = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound.value += 1
                    }
                }
            }) {
                Text("Sail South")
            }
        }
    }
}

