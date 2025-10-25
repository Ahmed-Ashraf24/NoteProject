package com.example.noteproject.Data.DataSource.API

import com.example.noteproject.Data.models.APIModel.NoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NoteRetrofitClient {
    val api: NoteService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(
            GsonConverterFactory.create()
        )
            .build()
            .create(NoteService::class.java)
    }
}