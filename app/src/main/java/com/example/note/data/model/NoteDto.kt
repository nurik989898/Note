package com.example.note.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = DEFAULT_ID,
    val title: String? = null,
    val description:String? = null
)

{
    companion object{
        const val DEFAULT_ID = 0
    }
}
