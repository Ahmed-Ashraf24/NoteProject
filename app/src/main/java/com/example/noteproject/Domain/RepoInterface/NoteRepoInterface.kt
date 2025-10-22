package com.example.noteproject.Domain.RepoInterface

import com.example.noteproject.Data.models.Note
import com.example.noteproject.Data.models.SearchQuery
import kotlinx.coroutines.flow.Flow

interface NoteRepoInterface {
     fun getAllNotes(): Flow<List<Note>>
    suspend fun addNote(note:Note)
    suspend fun updateNote(note:Note)
    suspend fun deleteNote(note:Note)
    suspend fun getNoteThatMatchesQuery(query: SearchQuery): Flow<List<Note>>

}