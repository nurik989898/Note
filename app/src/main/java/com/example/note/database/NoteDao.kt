package com.example.note.database

import androidx.room.*
import androidx.room.Dao
import com.example.note.domain.model.NoteEntity

@Dao
interface NoteDao {
    //CRUD
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(noteEntity: NoteEntity)
    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteEntity>
    @Update
    suspend fun editNote(noteEntity: NoteEntity)
    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)
}