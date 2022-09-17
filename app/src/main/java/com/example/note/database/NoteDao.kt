package com.example.note.database

import androidx.room.*
import androidx.room.Dao
import com.example.note.data.model.NoteDto

@Dao
interface NoteDao {
    //CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(noteModelEntity: NoteDto)

    @Query("SELECT * FROM notedto")
    suspend fun getAllNotes(): List<NoteDto>

    @Update
    suspend fun editNote(noteEntity: NoteDto)

    @Delete
    suspend fun deleteNote(noteEntity: NoteDto)
}