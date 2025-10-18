package com.example.noteproject

import android.app.Application
import android.content.Context

class NoteApplication: Application() {
    companion object{
        private lateinit var instance: NoteApplication

        fun getAppContext(): Context = instance.applicationContext

    }

    override fun onCreate() {
        instance=this
        super.onCreate()
    }
}