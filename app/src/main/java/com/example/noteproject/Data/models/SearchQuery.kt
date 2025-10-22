package com.example.noteproject.Data.models



@JvmInline
value class SearchQuery private constructor(private val query: String) {
    constructor(query: String, ignoreCase: Boolean=true):this(query = "%${query}%")

    override fun toString()=query
}


