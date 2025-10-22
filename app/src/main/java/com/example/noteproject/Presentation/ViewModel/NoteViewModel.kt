package com.example.noteproject.Presentation.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteproject.Data.DataSource.LocalDatabase.LocalDataBase
import com.example.noteproject.Data.Repository.NoteRepoImplement
import com.example.noteproject.Data.models.Note
import com.example.noteproject.Data.models.SearchQuery
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NoteViewModel() : ViewModel() {
    private val noteRepo = NoteRepoImplement(LocalDataBase())
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList
    private val _searchResultList = MutableStateFlow<List<Note>>(emptyList())
    val searchResultList = _searchResultList
init {
    getAllNotes()
}

   private fun getAllNotes() {
        viewModelScope.launch {
            noteRepo.getAllNotes()
                .collect { notes ->
                _noteList.value = notes
                Log.d("NoteViewModel get all notes", "Collected notes: $notes")
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepo.addNote(note)

        }
    }
    fun getNoteFromSearch(query: SearchQuery){
        viewModelScope.launch {
            noteRepo.getNoteThatMatchesQuery(query).collect { noteList->
                _searchResultList.value=noteList
                Log.d("NoteViewModel from search", "Collected notes: $noteList")

            }
        }
    }
    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepo.updateNote(note)

        }
    }
    fun deleteNote(note:Note){
        viewModelScope.launch {
            noteRepo.deleteNote(note)
            getAllNotes()

        }
    }

}