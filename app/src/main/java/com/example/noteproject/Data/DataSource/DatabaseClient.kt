package com.example.noteproject.Data.DataSource

import com.example.noteproject.Data.models.Note
import com.example.noteproject.Data.models.SearchQuery
import kotlinx.coroutines.flow.Flow

interface DatabaseClient {
    fun getAllNotes(): Flow<List<Note>>
    suspend fun addNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    fun getNoteThatMatchesQuery(query: SearchQuery): Flow<List<Note>>

}