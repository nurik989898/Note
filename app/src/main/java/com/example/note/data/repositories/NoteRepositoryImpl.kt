package com.example.note.data.repositories

import com.example.note.core.BaseRepository
import com.example.note.core.Resource
import com.example.note.data.model.Note
import com.example.note.database.NoteDao
import com.example.note.domain.repository.NoteRepository
import com.example.note.domain.repository.noteEntityToNote
import com.example.note.domain.repository.noteToNoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao): NoteRepository,BaseRepository() {
    override fun addNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.addNote(note.noteToNoteEntity())
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> = doRequest {
        noteDao.getAllNotes().map { entity -> entity.noteEntityToNote() }
    }


    override fun editNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.editNote(note.noteToNoteEntity())
    }


    override fun deleteNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNote(note.noteToNoteEntity())
    }
}