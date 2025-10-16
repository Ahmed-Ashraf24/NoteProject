package com.example.noteproject.Screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.noteproject.Components.CustomDialog
import com.example.noteproject.Components.EditNoteTopBar
import com.example.noteproject.Components.NewNoteTopBar
import com.example.noteproject.models.Note
import com.example.noteproject.ui.theme.Typography
import com.example.noteproject.ui.theme.backGroundColor
import com.example.noteproject.ui.theme.contentTitleColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteScreen(navController: NavController, note: Note?) {
    var editable by remember { mutableStateOf(false) }
    var readOnly = !editable

    Log.d("note", note.toString())
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = backGroundColor,
        topBar = {
            if (editable || note == null) {
                readOnly = false
                var saveClicked by remember {
                    mutableStateOf(false)
                }
                //in the ui design every top bar has padding of 53px except edit top bar have a padding  of 75
                NewNoteTopBar(
                    modifier = Modifier
                        .padding(top = 53.dp, start = 23.dp, end = 25.dp)
                        .fillMaxWidth(),
                    onBackClicked = { navController.popBackStack() }, onSaveClicked = {
                        saveClicked = !saveClicked

                    })
                if (saveClicked) {
                    CustomDialog(onDismiss = { saveClicked = !saveClicked }, onConfirm = { })

                }

            } else {
                EditNoteTopBar(
                    modifier = Modifier
                        .padding(top = 75.dp, start = 23.dp, end = 25.dp)
                        .fillMaxWidth(),
                    onBackClicked = { navController.popBackStack() },
                    onEditClicked = { editable = true }
                )
            }
        },

        ) {
        var title by remember { mutableStateOf(note?.title ?: "") }
        var content by remember { mutableStateOf(note?.content ?: "") }
        NoteScreenBody(title, content, { content = it }, { title = it }, readOnly = readOnly)

    }
}

@Composable
fun NoteScreenBody(
    title: String,
    content: String,
    onContentChange: (String) -> (Unit),
    onTitleChange: (String) -> (Unit),
    readOnly: Boolean
) {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.padding(start = 24.dp, top = 141.dp, bottom = 14.dp)) {
            BasicTextField(
                modifier = Modifier,
                value = title,
                onValueChange = onTitleChange,
                readOnly = readOnly,
                textStyle = Typography.titleLarge.copy(lineHeight = 50.sp, color = Color.White),
                decorationBox = { innerTextField ->
                    if (title.isEmpty()) Text(
                        "Title",
                        style = Typography.titleLarge,
                        color = contentTitleColor
                    )
                    innerTextField()
                }
            )

        }
        Row(
            Modifier
                .padding(start = 24.dp, end = 24.dp, bottom = 64.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
            BasicTextField(
                modifier = Modifier,
                value = content,
                onValueChange = onContentChange,
                readOnly = readOnly,
                textStyle = Typography.bodyMedium.copy(
                    fontSize = 23.sp,
                    lineHeight = 39.sp,
                    color = Color.White
                ),
                decorationBox = { innerTextField ->
                    if (content.isEmpty()) Text(
                        "Type something...",
                        style = Typography.bodyMedium.copy(fontSize = 23.sp),
                        color = contentTitleColor
                    )
                    innerTextField()
                }
            )
        }
    }
}

@Preview
@Composable
private fun EditScreenPrev() {
    NoteScreen(navController = NavController(LocalContext.current), Note(null, null))
}