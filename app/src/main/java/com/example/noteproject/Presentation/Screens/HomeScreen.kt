package com.example.noteproject.Presentation.Screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.noteproject.R
import com.example.noteproject.Data.models.Note
import com.example.noteproject.Presentation.Components.CustomCardButton
import com.example.noteproject.Presentation.Components.EmptyStateContent
import com.example.noteproject.Presentation.Components.NoteListComponent
import com.example.noteproject.Presentation.ViewModel.NoteViewModel
import com.example.noteproject.Presentation.theme.backGroundColor
import com.example.noteproject.Presentation.theme.Typography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, viewModel: NoteViewModel) {
    val noteList by viewModel.noteList.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backGroundColor,
        topBar = {
            HomeScreenTopBar(onSearchClicked = { navController.navigate("search") })
        },
        bottomBar = {
            BottomBar(
                onButtonClicked = { navController.navigate("note") }
            )
        }
    ) {


        if (noteList.isEmpty()) {
            EmptyStateContent(
                modifier = Modifier
                    .fillMaxSize(),
                label = "Create your first note !",
                imagePainter = painterResource(R.drawable.ic_empty_state)
            )

        } else

            NoteListComponent(
                Modifier
                    .padding(top = 160.dp)
                    .fillMaxSize(),
                noteList,
            ) { note, isDeleteView ->
                if (isDeleteView) {
                    viewModel.deleteNote(note)
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
fun HomeScreenTopBar(onSearchClicked: () -> (Unit)) {
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

            CustomCardButton(
                modifier = Modifier.size(50.dp),
                imageVector = ImageVector.vectorResource(R.drawable.search),
                surfaceBackground = _root_ide_package_.com.example.noteproject.Presentation.theme.customButtonColor,
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
                surfaceBackground = _root_ide_package_.com.example.noteproject.Presentation.theme.customButtonColor,
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
        Row(
            Modifier
                .background(Color.Transparent)
                .padding(end = 35.dp), horizontalArrangement = Arrangement.End
        ) {
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

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun HomeScreenPreview() {

    HomeScreen(navController = NavController(LocalContext.current), viewModel = viewModel())

}

