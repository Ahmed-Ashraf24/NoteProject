package com.example.noteproject.Data.models.APIModel

import retrofit2.http.GET

interface NoteService {
    @GET("todos")
  suspend fun getAllNotes():NoteResponse
}