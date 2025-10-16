package com.example.noteproject.Screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.noteproject.Components.CustomSearchBar
import com.example.noteproject.Components.EmptyStateContent
import com.example.noteproject.R
import com.example.noteproject.ui.theme.backGroundColor
val query="title"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable

fun SearchScreen(navController: NavController) {

    var found by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backGroundColor,
        topBar = {
            SearchTopBar(Modifier.padding(end = 27.dp, start = 27.dp, top = 80.dp), query = searchQuery,{newText->
            searchQuery=newText
            })
                 },

    ) {
            if (searchQuery.contains(query,true)){
                found=true
            }
            else{
                found=false
            }
        Log.d("found flag",found.toString())

        if(!found&&!searchQuery.isEmpty()) {
            EmptyStateContent(
                modifier = Modifier
                    .fillMaxSize(),
                label = "File not found. Try searching again.",
                imagePainter = painterResource(R.drawable.ic_empty_state_search)
            )
        }

    }
}

@Composable
fun SearchTopBar(modifier: Modifier = Modifier,query:String,onQueryChange:(String)->(Unit)) {
    Row(modifier=modifier) {
        CustomSearchBar(modifier = Modifier.fillMaxWidth(), query = query, label = "Search by the keyword...", onQueryChange = onQueryChange)
    }
}
