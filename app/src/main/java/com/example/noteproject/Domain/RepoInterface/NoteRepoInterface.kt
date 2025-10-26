package com.example.noteproject.Domain.RepoInterface

import com.example.noteproject.Data.models.APIModel.NoteResponse
import com.example.noteproject.Data.models.DatabaseModel.Note
import com.example.noteproject.Data.models.DatabaseModel.SearchQuery
import kotlinx.coroutines.flow.Flow

interface NoteRepoInterface {
    fun getAllNotes(): Flow<List<Note>>
    suspend fun addNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(note: Note)
    suspend fun getNoteThatMatchesQuery(query: SearchQuery): Flow<List<Note>>
    suspend fun cacheNote(noteList:List<Note>)
}