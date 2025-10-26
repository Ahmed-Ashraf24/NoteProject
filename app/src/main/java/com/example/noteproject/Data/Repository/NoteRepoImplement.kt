package com.example.noteproject.Data.Repository

import com.example.noteproject.Data.DataSource.DatabaseClient
import com.example.noteproject.Data.models.APIModel.NoteResponse
import com.example.noteproject.Data.models.DatabaseModel.Note
import com.example.noteproject.Data.models.DatabaseModel.SearchQuery
import com.example.noteproject.Domain.RepoInterface.NoteRepoInterface
import kotlinx.coroutines.flow.Flow

class NoteRepoImplement(private val databaseClient: DatabaseClient) : NoteRepoInterface {
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

    override suspend fun cacheNote(noteList: List<Note>) {
        noteList.forEach {note->
            databaseClient.addNote(note)
        }
    }
}