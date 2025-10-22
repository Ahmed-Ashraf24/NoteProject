package com.example.noteproject.Presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteproject.Presentation.Screens.HomeScreen
import com.example.noteproject.Data.models.Note
import com.example.noteproject.Presentation.Screens.NoteScreen
import com.example.noteproject.Presentation.Screens.SearchScreen
import com.example.noteproject.Presentation.ViewModel.NoteViewModel
import com.example.noteproject.Presentation.theme.NoteProjectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    val noteViewModel = NoteViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            NoteProjectTheme {

                val navController = rememberNavController()
                viewModel(NoteViewModel::class, this)

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { HomeScreen(navController, noteViewModel) }
                    composable("search") {
                        SearchScreen(
                            navController, noteViewModel
                        )
                    }
                    composable(
                        route = "note?title={title}&content={content}&id={id}",

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
                            },
                            navArgument("id") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) { backStackEntry ->

                        val title = backStackEntry.arguments?.getString("title")
                        val content = backStackEntry.arguments?.getString("content")
                        val id = backStackEntry.arguments?.getInt("id")

                        val isNoteNull = listOf(id, title, content).all { it == null }
                        NoteScreen(
                            navController = navController,
                            note = Note(
                                id = id!!,
                                title = title,
                                content = content
                            ).takeIf { !isNoteNull && id != -1 },
                            viewModel = noteViewModel
                        )

                    }
                }
            }
        }
    }
}

