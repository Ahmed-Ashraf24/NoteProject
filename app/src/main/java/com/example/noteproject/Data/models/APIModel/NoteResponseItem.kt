package com.example.noteproject.Data.models.APIModel

data class NoteResponseItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)