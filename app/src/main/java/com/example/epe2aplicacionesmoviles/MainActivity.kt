package com.example.epe2aplicacionesmoviles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.epe2aplicacionesmoviles.service.WordList
import com.example.epe2aplicacionesmoviles.ui.theme.Epe2AplicacionesMovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Epe2AplicacionesMovilesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        onNavigate = {
                            val intent = Intent(this, SecondActivity::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(onNavigate: () -> Unit, modifier: Modifier = Modifier) {
    val palabraDelDia = remember {
        WordList.wordList.random()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "📘 Palabra del Día", style = MaterialTheme.typography.headlineMedium)
            Spacer(
                modifier = Modifier.height(16.dp))
            Text(
                text = palabraDelDia.word, style = MaterialTheme.typography.titleLarge)
            Text(
                text = palabraDelDia.meaning, style = MaterialTheme.typography.bodyLarge)

            Button(onClick = onNavigate) {
                Text("Practicar nuevas palabras")
            }
        }
    }
}

