package com.example.note.domain.use_case


import com.example.note.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor (private val noteRepository: NoteRepository) {
fun getAllNotes()= noteRepository.getAllNotes()
}