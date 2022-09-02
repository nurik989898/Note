package com.example.note.data.repositories

import com.example.note.core.Resource
import com.example.note.data.model.Note
import com.example.note.database.NoteDao
import com.example.note.domain.model.NoteEntity
import com.example.note.domain.repository.NoteRepository
import com.example.note.domain.repository.noteToNoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override fun addNote(note: Note) : Flow<Resource<Unit>> = flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.addNote(note.noteToNoteEntity())
            emit(Resource.Success(data))
        }catch (e: Exception){
            emit(Resource.Error(e.localizedMessage ?:"Unknown message"))
        }

    }

    override fun getAllNotes():Flow<Resource<List<Note>>>  {
        TODO("Not yet implemented")
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }

    override fun deleteNote(note: Note): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }
}