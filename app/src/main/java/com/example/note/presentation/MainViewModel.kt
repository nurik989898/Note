package com.example.note.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.note.data.model.Note
import com.example.note.domain.use_case.AddNoteUseCase
import com.example.note.domain.use_case.DeleteNoteUseCase
import com.example.note.domain.use_case.EditNoteUseCase
import com.example.note.domain.use_case.GetAllNotesUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase

):ViewModel() {
    private val _addNoteLD = MutableLiveData<Note>()
     val addNoteLD: LiveData<Note> = MutableLiveData()

    fun addNote(){
        _addNoteLD.value = Note()
    }
}