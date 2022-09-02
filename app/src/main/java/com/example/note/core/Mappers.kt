package com.example.note.domain.repository

import com.example.note.data.model.Note
import com.example.note.domain.model.NoteEntity

fun NoteEntity.noteEntityToNote()=Note(

        id = this.id,
        title = this.title,
        description = this.description
)

fun Note.noteToNoteEntity()=NoteEntity(
        id =this.id,
        title = this.title,
        description = this.description
    )
