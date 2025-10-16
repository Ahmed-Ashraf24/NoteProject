package com.example.noteproject.Screens

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.noteproject.Components.CustomCardButton
import com.example.noteproject.Components.CustomDialog
import com.example.noteproject.Components.EmptyStateContent
import com.example.noteproject.Components.NoteItem
import com.example.noteproject.R
import com.example.noteproject.models.Note
import com.example.noteproject.ui.theme.Typography
import com.example.noteproject.ui.theme.backGroundColor
import com.example.noteproject.ui.theme.customButtonColor
import com.example.noteproject.ui.theme.noteColorList

val itemList=mutableListOf<Note>()
var counter=0
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    itemList.add(Note(title="title 1: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 1"))
    itemList.add(Note(title="title 2: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 2"))
    itemList.add(Note(title="title 3: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 3"))
    itemList.add(Note(title="title 4: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 4"))
    itemList.add(Note(title="title 5: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 5"))
    itemList.add(Note(title="title 6: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 6"))
    itemList.add(Note(title="title 7: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 7"))
    itemList.add(Note(title="title 8: it supposed to be a long book name that i didn't remember its name",content="this is the content of the title 8"))
   Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backGroundColor,
        topBar = { HomeScreenTopBar(onSearchClicked = {navController.navigate("search")}) },
        bottomBar = {
            BottomBar(
            onButtonClicked = { navController.navigate("note") }
        )
        }
    ) {
        if (itemList.isEmpty()){
        EmptyStateContent(modifier = Modifier
            .fillMaxSize(), label = "Create your first note !", imagePainter = painterResource(R.drawable.ic_empty_state))

        }
        else
        HomePageContent(Modifier
            .padding(top = 160.dp)
            .fillMaxSize(),itemList){note->
            navController.navigate("note?title=${Uri.encode(note.title)}&content=${Uri.encode(note.content)}")
        }

    }
}

@Composable
fun HomePageContent(modifier: Modifier = Modifier, notes: List<Note>, onItemClicked:(note: Note)->(Unit)) {

    LazyColumn(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        items(notes){note->

            Row(Modifier
                .padding(horizontal = 14.dp, vertical = 14.dp)
                .fillMaxWidth()) {
                NoteItem(Modifier.weight(1f),
                    title = note.title?:"",

                    color = noteColorList.get(counter++ %noteColorList.size),
                    onClicked = { onItemClicked(note) }
                )
            }
        }
    }
}
@Composable
fun HomeScreenTopBar(onSearchClicked:()->(Unit)) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 51.dp, bottom = 42.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(Modifier.padding(start = 24.dp)) {
            Text("Notes", style = Typography.titleLarge, color = Color.White)
        }
        Row(
            Modifier.padding(end = 25.dp),
            horizontalArrangement = Arrangement.spacedBy(21.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var showDialog by remember { mutableStateOf(false) }
            if (showDialog){
                CustomDialog(Modifier,{showDialog=false},{})
            }
            CustomCardButton(
                modifier = Modifier.size(50.dp),
                imageVector = ImageVector.vectorResource(R.drawable.search),
                surfaceBackground = customButtonColor,
                onClicked = onSearchClicked,
                description = "preview",
                alphaValue = 1f,
                shape = RoundedCornerShape(15.dp),
                shadowEvaluation = 8,
                iconPadding = 12
            )
            CustomCardButton(
                modifier = Modifier.size(50.dp),
                imageVector = ImageVector.vectorResource(R.drawable.info_outline),
                surfaceBackground = customButtonColor,
                onClicked = {

                            },
                description = "preview",
                shape = RoundedCornerShape(15.dp),
                alphaValue = 1f,
                shadowEvaluation = 8,
                iconPadding = 12
            )
        }
    }

}

@Composable
fun BottomBar(onButtonClicked: () -> Unit) {
    Box(
        Modifier
            .padding(bottom = 43.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomEnd
    ) {
        Row(Modifier
            .background(Color.Transparent)
            .padding(end = 35.dp)
            , horizontalArrangement = Arrangement.End) {
            CustomCardButton(
                Modifier.size(70.dp),
                imageVector = ImageVector.vectorResource(R.drawable.plus),
                surfaceBackground = Color(0xFF252525),
                onClicked = onButtonClicked,
                description = "",
                shape = RoundedCornerShape(50.dp),
                alphaValue = 1f,
                shadowEvaluation = 4,
                iconPadding = 22
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}

