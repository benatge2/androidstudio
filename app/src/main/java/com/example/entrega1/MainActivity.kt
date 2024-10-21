@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.entrega1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.entrega1.ui.theme.Entrega1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Entrega1Theme {
                AppNagusia()
            }
        }
    }
}

@Composable
fun AppNagusia() {
    var currentScreen by remember { mutableStateOf("Hasiera") }
    var savedData by remember { mutableStateOf("") }

    when (currentScreen) {
        "Hasiera" -> HasieraPantaila(onNavigate = { currentScreen = it })
        "Pantaila1" -> Pantaila1(onNavigate = { currentScreen = "Hasiera" }, onSave = { savedData = it })
        "Pantaila2" -> Pantaila2(onNavigate = { currentScreen = "Hasiera" }, savedData = savedData)
    }
}

@Composable
fun HasieraPantaila(onNavigate: (String) -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Aplikazio Hasiera") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { onNavigate("Pantaila1") }) {
                Text("Joan Pantaila 1-era (Gehitu Datuak)")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onNavigate("Pantaila2") }) {
                Text("Joan Pantaila 2-ra (Erakutsi Datuak)")
            }
        }
    }
}

@Composable
fun Pantaila1(onNavigate: () -> Unit, onSave: (String) -> Unit) {
    var inputValue by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Pantaila 1 - Gehitu Datuak") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BasicTextField(
                value = inputValue,
                onValueChange = { inputValue = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        if (inputValue.isEmpty()) {
                            Text("Sartu testua hemen")
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                onSave(inputValue)
                onNavigate()
            }) {
                Text("Gorde eta itzuli Hasierara")
            }
        }
    }
}

@Composable
fun Pantaila2(onNavigate: () -> Unit, savedData: String) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Pantaila 2 - Erakutsi Datuak") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Gordetako Datuak:")
            Spacer(modifier = Modifier.height(16.dp))
            if (savedData.isNotEmpty()) {
                Text(text = savedData)
            } else {
                Text("Ez dago daturik gordeta.")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigate) {
                Text("Itzuli Hasierara")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HasieraPreview() {
    Entrega1Theme {
        HasieraPantaila(onNavigate = {})
    }
}

@Preview(showBackground = true)
@Composable
fun Pantaila1Preview() {
    Entrega1Theme {
        Pantaila1(onNavigate = {}, onSave = {})
    }
}

@Preview(showBackground = true)
@Composable
fun Pantaila2Preview() {
    Entrega1Theme {
        Pantaila2(onNavigate = {}, savedData = "Adibidez: Gordetako datuak hemen agertuko dira")
    }
}
