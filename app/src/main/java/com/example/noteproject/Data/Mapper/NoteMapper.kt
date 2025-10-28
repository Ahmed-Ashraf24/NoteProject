package com.example.noteproject.Data.Mapper

import com.example.noteproject.Data.models.APIModel.NoteResponseItem
import com.example.noteproject.Data.models.DatabaseModel.Note

object NoteMapper {
    fun toNote(noteItem: NoteResponseItem): Note{
        return Note(
            title = noteItem.title,
            content = ""
        )

    }
}