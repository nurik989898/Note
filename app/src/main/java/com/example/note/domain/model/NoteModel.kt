package com.example.note.domain.model

data class NoteModel(
    val id: Int = DEFAULT_ID,
    val title: String? = null,
    val description:String? = null
){
    companion object{
        const val DEFAULT_ID = 0
    }
}

