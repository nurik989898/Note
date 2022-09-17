package com.example.note.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note.data.model.NoteDto

@Database(entities = [NoteDto::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}