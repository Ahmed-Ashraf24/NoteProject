package com.example.noteproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteproject.Screens.HomeScreen
import com.example.noteproject.Screens.NoteScreen
import com.example.noteproject.Screens.SearchScreen
import com.example.noteproject.models.Note
import com.example.noteproject.ui.theme.NoteProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteProjectTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { HomeScreen(navController) }
                    composable("search") { SearchScreen(navController) }
                    composable(
                        route = "note?title={title}&content={content}",

                        arguments = listOf(
                            navArgument("title") {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            },
                            navArgument("content") {
                                type = NavType.StringType
                                nullable = true
                                defaultValue = null
                            }
                        )
                    ) { backStackEntry ->

                        val title = backStackEntry.arguments?.getString("title")
                        val content = backStackEntry.arguments?.getString("content")
                        val isNoteNull=listOf(title,content).all { it == null }
                        NoteScreen(navController, Note(title, content).takeIf{!isNoteNull})
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteProjectTheme {
        Greeting("Android")
    }
}