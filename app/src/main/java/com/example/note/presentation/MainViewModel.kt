package com.example.note.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note.core.Resource
import com.example.note.core.UIState
import com.example.note.data.model.Note
import com.example.note.domain.use_case.AddNoteUseCase
import com.example.note.domain.use_case.DeleteNoteUseCase
import com.example.note.domain.use_case.EditNoteUseCase
import com.example.note.domain.use_case.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase

):ViewModel() {
    private val _addNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val addNoteState = _addNoteState.asStateFlow()

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val getAllNotesState= _getAllNotesState.asStateFlow()

    fun addNote(note: Note){
        viewModelScope.launch {
            addNoteUseCase.addNote(note).collect{
        when(it){
            is Resource.Loading ->{
                _addNoteState.value = UIState.Loading()
            }
            is Resource.Success ->{
                if (it.data != null)
                _addNoteState.value = UIState.Success(it.data)
            }
            is Resource.Error -> {
                _addNoteState.value = UIState.Error(it.message?:"Unknown message!")
            }
        }
            }
        }
    }
    fun getAllNotes(){
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect{
                when(it){
                    is Resource.Loading ->{
                        _getAllNotesState.value = UIState.Loading()
                    }
                    is Resource.Success ->{
                        if (it.data != null)
                            _getAllNotesState.value = UIState.Success(it.data)
                    }
                    is Resource.Error -> {
                        _getAllNotesState.value = UIState.Error(it.message?:"Unknown message!")
                    }
                }
            }
        }
    }

}