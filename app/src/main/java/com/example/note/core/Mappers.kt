package com.example.note.core

import com.example.note.data.model.NoteDto
import com.example.note.domain.model.NoteModel

fun NoteModel.noteEntityToNote() = NoteDto(
    id = this.id,
    title = this.title,
    description = this.description
)

fun NoteDto.noteToNoteEntity() = NoteModel(
    id = this.id,
    title = this.title,
    description = this.description
)
