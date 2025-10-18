package com.example.noteproject.Data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
@Entity(tableName = "Note")
data class Note(
    @PrimaryKey(autoGenerate = true) val id:Int =0,
    val title:String?,
    val content:String?
)
