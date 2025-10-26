package com.example.noteproject.Domain.RepoInterface

import com.example.noteproject.Data.models.DatabaseModel.Note

interface NoteApiRepo {
    suspend fun fetchNote():List<Note>
}