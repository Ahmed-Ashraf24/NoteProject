package com.example.noteproject.Data.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class RoomDataBase() : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: RoomDataBase? = null


        fun getInstance(context: Context): RoomDataBase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    RoomDataBase::class.java,
                    "note_database"
                ).build()
            }
        }
    }
}