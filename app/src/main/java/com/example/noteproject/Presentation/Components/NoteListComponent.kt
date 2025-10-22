package com.example.noteproject.Presentation.Components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noteproject.Data.models.Note
import com.example.noteproject.Presentation.theme.noteColorList


private var counter = 0
@Composable
fun NoteListComponent(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onItemClicked: (note: Note,isDeleteView: Boolean) -> (Unit)
) {
    var deleteModeNoteId by remember { mutableStateOf<Int?>(null) }
    LazyColumn(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        items(notes, key = { it.id ?: it.title ?: it.hashCode() }) { note ->
            val isDeleteView = note.id == deleteModeNoteId
            Row(
                Modifier
                    .padding(horizontal = 14.dp, vertical = 14.dp)
                    .fillMaxWidth()
            ) {
                NoteItem(
                    Modifier.weight(1f),
                    title = note.title ?: "",

                    color = noteColorList.get(
                        counter++ % noteColorList.size
                    ),
                    isDeleteView = isDeleteView,
                    onClicked = {deleteMode->
                        if (deleteMode) {
                            onItemClicked(note, true)
                            deleteModeNoteId = null
                        } else {
                            onItemClicked(note, false)
                        }
                                },
                    onLongClick = {
                        deleteModeNoteId = if (isDeleteView) null else note.id
                    }
                )
            }
        }
    }
}