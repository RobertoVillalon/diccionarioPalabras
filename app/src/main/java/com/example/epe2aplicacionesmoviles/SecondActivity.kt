package com.example.epe2aplicacionesmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.epe2aplicacionesmoviles.service.WordList
import com.example.epe2aplicacionesmoviles.ui.theme.Epe2AplicacionesMovilesTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Epe2AplicacionesMovilesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    WordListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WordListScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(WordList.wordList) { palabra ->
            WordItem(palabra.word, palabra.meaning)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun WordItem(palabra: String, significado: String) {
    Column {
        Text(
            text = palabra,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = significado,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}