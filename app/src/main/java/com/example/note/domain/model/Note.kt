package com.example.note.domain.model

import androidx.room.Entity

@Entity
data class NoteEntity(
    val id: Int = DEFAULT_ID,
    val title: String? = null,
    val description:String? = null
){
    companion object{
        const val DEFAULT_ID = 0
    }
}

