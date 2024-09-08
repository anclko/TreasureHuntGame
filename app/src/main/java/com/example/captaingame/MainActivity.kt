package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
        //values
        var treasuresFound by remember { mutableStateOf(0) }
        var direction by remember { mutableStateOf("North") }
        val stormChance = 0.2
        val stormMessage = remember { mutableStateOf("") }

        Column {
            Text("Treasures Found: $treasuresFound")
            Text("Current Direction: $direction")

            //storm message if present
            if (stormMessage.value.isNotEmpty()) {
                Text(stormMessage.value)
            }

            Button(onClick = {
                direction = "East"
                if (Random.nextFloat() < stormChance) {
                    //if storm, reset treasures and show message
                    treasuresFound = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound += 1
                    }
                }
            }) {
                Text("Sail East")
            }

            Button(onClick = {
                direction = "West"
                if (Random.nextFloat() < stormChance) {
                    treasuresFound = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound += 1
                    }
                }
            }) {
                Text("Sail West")
            }

            Button(onClick = {
                direction = "North"
                if (Random.nextFloat() < stormChance) {
                    treasuresFound = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound += 1
                    }
                }
            }) {
                Text("Sail North")
            }

            Button(onClick = {
                direction = "South"
                if (Random.nextFloat() < stormChance) {
                    treasuresFound = 0
                    stormMessage.value = "You lost your treasure in the sea after a storm!"
                } else {
                    stormMessage.value = "Smooth sailing"
                    if (Random.nextBoolean()) {
                        treasuresFound += 1
                    }
                }
            }) {
                Text("Sail South")
            }
        }
    }
}

