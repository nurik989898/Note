package com.example.note.di

import android.content.Context
import com.example.note.data.repositories.NoteRepositoryImpl
import com.example.note.database.NoteDao
import com.example.note.database.NoteDataBase
import com.example.note.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) =
        androidx.room.Room.databaseBuilder(
            context,
            NoteDataBase::class.java,
            "note_db"
        ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDao()

}