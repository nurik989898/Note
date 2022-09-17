package com.example.note.data.repositories

import com.example.note.core.BaseRepository
import com.example.note.core.Resource
import com.example.note.core.noteEntityToNote
import com.example.note.data.model.NoteDto
import com.example.note.database.NoteDao
import com.example.note.domain.repository.NoteRepository
import com.example.note.core.noteToNoteEntity
import com.example.note.domain.model.NoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository,
    BaseRepository() {
    override suspend fun addNote(noteModel: NoteModel): Flow<Resource<Unit>> = doRequest {
        noteDao.addNote(noteModel.noteEntityToNote())
    }

    override suspend fun getAllNotes(): Flow<Resource<List<NoteModel>>> = doRequest{
        noteDao.getAllNotes().map { it.noteToNoteEntity() }
    }

    override suspend fun editNote(noteModel: NoteModel): Flow<Resource<Unit>> = doRequest{
        noteDao.editNote(noteModel.noteEntityToNote())
    }

    override suspend fun deleteNote(noteModel: NoteModel): Flow<Resource<Unit>> = doRequest{
        noteDao.deleteNote(noteModel.noteEntityToNote())
    }
}