@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.entrega1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
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
    var currentScreen by remember { mutableStateOf("Login") }
    var username by remember { mutableStateOf("") }

    val posts = remember { mutableStateListOf<Post>() }

    when (currentScreen) {
        "Login" -> LoginScreen(onLogin = { name ->
            username = name
            currentScreen = "Forum"
        })
        "Forum" -> ForumScreen(username = username, posts = posts, onLogout = { currentScreen = "Login" })
    }
}

@Composable
fun LoginScreen(onLogin: (String) -> Unit) {
    var inputValue by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Login") }) }
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
                            Text("Sartu zure izena")
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onLogin(inputValue) }) {
                Text("Sartu")
            }
        }
    }
}

@Composable
fun ForumScreen(username: String, posts: MutableList<Post>, onLogout: () -> Unit) {
    var postText by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Foroa") },
                actions = {
                    IconButton(onClick = onLogout) {
                        Text("Irten")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            BasicTextField(
                value = postText,
                onValueChange = { postText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                decorationBox = { innerTextField ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        if (postText.isEmpty()) {
                            Text("Idatzi zure iruzkina")
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                if (postText.isNotEmpty()) {
                    posts.add(Post(username, postText))
                    postText = ""
                }
            }) {
                Text("Bidali")
            }
            Spacer(modifier = Modifier.height(16.dp))

            posts.forEach { post ->
                PostView(post = post)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

data class Post(val username: String, val text: String, var likes: Int = 0)

@Composable
fun PostView(post: Post) {
    var liked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary)
            .padding(8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "${post.username}: ${post.text}")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "${post.likes} Likes")
            Button(onClick = {
                if (!liked) {
                    post.likes++
                    liked = true
                }
            }) {
                Text(if (liked) "Liked" else "Like")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Entrega1Theme {
        LoginScreen(onLogin = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ForumScreenPreview() {
    Entrega1Theme {
        val posts = mutableListOf<Post>()
        posts.add(Post("User1", "Hau iruzkin bat da!"))
        posts.add(Post("User2", "Kaixo denei!"))
        ForumScreen(username = "User", posts = posts, onLogout = {})
    }
}
