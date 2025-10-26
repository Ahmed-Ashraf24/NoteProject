package com.example.noteproject.Data.Repository

import com.example.noteproject.Data.DataSource.API.NoteRetrofitClient
import com.example.noteproject.Data.Mapper.NoteMapper
import com.example.noteproject.Data.models.APIModel.NoteService
import com.example.noteproject.Data.models.DatabaseModel.Note
import com.example.noteproject.Domain.RepoInterface.NoteApiRepo
import com.example.noteproject.Domain.RepoInterface.NoteRepoInterface

class NoteApiRepoImplement(val localNoteRepo: NoteRepoInterface): NoteApiRepo {
    override suspend fun fetchNote(): List<Note> {
        return NoteRetrofitClient
            .api
            .getAllNotes()
            .map(NoteMapper::toNote)
            .also {
                localNoteRepo.cacheNote(it)
            }
    }
}