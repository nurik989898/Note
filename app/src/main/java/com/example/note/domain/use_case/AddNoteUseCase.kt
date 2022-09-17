package com.example.note.domain.use_case

import com.example.note.core.noteToNoteEntity
import com.example.note.data.model.NoteDto
import com.example.note.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    suspend fun addNote(noteDto: NoteDto) = noteRepository.addNote(noteDto.noteToNoteEntity())
}