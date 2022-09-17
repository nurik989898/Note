package com.example.note.domain.repository

import com.example.note.core.Resource
import com.example.note.data.model.NoteDto
import com.example.note.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun addNote(noteModel: NoteModel): Flow<Resource<Unit>>
    suspend fun getAllNotes(): Flow<Resource<List<NoteModel>>>
    suspend fun editNote(noteModel: NoteModel): Flow<Resource<Unit>>
    suspend fun deleteNote(noteModel: NoteModel): Flow<Resource<Unit>>
}