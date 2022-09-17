package com.example.note.di

import com.example.note.data.repositories.NoteRepositoryImpl
import com.example.note.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(noteRepositoryImpl: NoteRepositoryImpl) : NoteRepository

}
