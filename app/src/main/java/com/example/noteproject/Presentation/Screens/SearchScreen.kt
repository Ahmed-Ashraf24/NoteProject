package com.example.noteproject.Presentation.Screens

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.noteproject.Data.models.SearchQuery
import com.example.noteproject.Presentation.Components.EmptyStateContent
import com.example.noteproject.Presentation.Components.NoteListComponent
import com.example.noteproject.Presentation.ViewModel.NoteViewModel

import com.example.noteproject.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun SearchScreen(navController: NavController, noteViewModel: NoteViewModel) {
    var found by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf("") }
    val searchResult by noteViewModel.searchResultList.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = _root_ide_package_.com.example.noteproject.Presentation.theme.backGroundColor,
        topBar = {
            SearchTopBar(
                Modifier.padding(end = 27.dp, start = 27.dp, top = 80.dp),
                query = searchQuery, { newText ->
                    searchQuery = newText
                })
        },

        ) {
        noteViewModel.getNoteFromSearch(SearchQuery(searchQuery))
        if (searchResult.isNotEmpty()) {
            found = true
        } else {
            found = false
        }
        Log.d("found flag", found.toString())

        if (!found && !searchQuery.isEmpty()) {
            EmptyStateContent(
                modifier = Modifier
                    .fillMaxSize(),
                label = "File not found. Try searching again.",
                imagePainter = painterResource(R.drawable.ic_empty_state_search)
            )
        } else
            NoteListComponent(
                Modifier
                    .padding(top = 160.dp)
                    .fillMaxSize(),
                searchResult,
            ) { note, isDeleteView ->
                if (isDeleteView) {
                    noteViewModel.deleteNote(note)
                } else {
                    navController.navigate(
                        "note?title=${Uri.encode(note.title)}&content=${
                            Uri.encode(
                                note.content
                            )
                        }&id=${note.id}"
                    )
                }
            }

    }
}

@Composable
fun SearchTopBar(modifier: Modifier = Modifier, query: String, onQueryChange: (String) -> (Unit)) {
    Row(modifier = modifier) {
        _root_ide_package_.com.example.noteproject.Presentation.Components.CustomSearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = query,
            label = "Search by the keyword...",
            onQueryChange = onQueryChange
        )
    }
}
