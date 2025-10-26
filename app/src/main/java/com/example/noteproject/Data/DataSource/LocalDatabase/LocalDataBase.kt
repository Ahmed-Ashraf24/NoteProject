package com.example.noteproject.Data.DataSource.LocalDatabase

import com.example.noteproject.Data.DataSource.DatabaseClient
import com.example.noteproject.Data.models.DatabaseModel.Note
import com.example.noteproject.Data.models.DatabaseModel.RoomDataBase
import com.example.noteproject.Data.models.DatabaseModel.SearchQuery
import com.example.noteproject.NoteApplication
import kotlinx.coroutines.flow.Flow

class LocalDataBase : DatabaseClient {
    private val localDatabase = RoomDataBase.getInstance(NoteApplication.getAppContext())
    override fun getAllNotes(): Flow<List<Note>> {
        return localDatabase.noteDao().getAllNotes()
    }

    override suspend fun addNote(note: Note) {
        localDatabase.noteDao().addNote(note)
    }

    override suspend fun updateNote(note: Note) {
        localDatabase.noteDao().editNote(note)

    }

    override suspend fun deleteNote(note: Note) {
        localDatabase.noteDao().deleteNote(note)
    }

    override fun getNoteThatMatchesQuery(query: SearchQuery): Flow<List<Note>> {
        return localDatabase.noteDao().getNotesMatchesQuery(query.toString())
    }
}