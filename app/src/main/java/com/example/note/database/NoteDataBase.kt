package com.example.note.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note.domain.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}