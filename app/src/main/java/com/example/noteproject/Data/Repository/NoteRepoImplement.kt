package com.example.noteproject.Data.Repository

import com.example.noteproject.Data.DataSource.DatabaseClient
import com.example.noteproject.Data.models.Note
import com.example.noteproject.Data.models.SearchQuery
import com.example.noteproject.Domain.RepoInterface.NoteRepoInterface
import kotlinx.coroutines.flow.Flow

class NoteRepoImplement(private val databaseClient: DatabaseClient): NoteRepoInterface {
    override fun getAllNotes(): Flow<List<Note>> {
       return databaseClient.getAllNotes()
    }

    override suspend fun addNote(note: Note) {
        databaseClient.addNote(note)
    }

    override suspend fun updateNote(note: Note) {
        databaseClient.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        databaseClient.deleteNote(note)
    }

    override suspend fun getNoteThatMatchesQuery(query: SearchQuery): Flow<List<Note>> {
        return databaseClient.getNoteThatMatchesQuery(query)
    }
}