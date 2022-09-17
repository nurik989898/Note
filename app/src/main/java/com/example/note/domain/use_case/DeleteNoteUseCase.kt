package com.example.note.domain.use_case

import com.example.note.core.noteToNoteEntity
import com.example.note.data.model.NoteDto
import com.example.note.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {
suspend fun deleteNote(noteDto: NoteDto)= noteRepository.deleteNote(noteDto.noteToNoteEntity())
}