package com.example.noteproject.Data.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * From Note")
     fun getAllNotes(): Flow<List<Note>>

    @Insert
   suspend fun addNote(note:Note)

    @Update
   suspend fun editNote(note: Note)

    @Delete
   suspend fun deleteNote(note:Note)

   @Query("SELECT *From Note where title like :query or content like :query ")
    fun getNotesMatchesQuery(query: String): List<Note>
}