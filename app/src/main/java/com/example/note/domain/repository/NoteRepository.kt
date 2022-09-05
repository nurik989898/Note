package com.example.note.domain.repository

import com.example.note.core.Resource
import com.example.note.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun addNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes():Flow<Resource<List<Note>>>

    fun editNote(note: Note):Flow<Resource<Unit>>

    fun deleteNote(note: Note):Flow<Resource<Unit>>
}