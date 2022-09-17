package com.example.note.presentation
import com.example.note.core.BaseViewModel
import com.example.note.core.UIState
import com.example.note.core.UIState.Success
import com.example.note.data.model.NoteDto
import com.example.note.domain.use_case.AddNoteUseCase
import com.example.note.domain.use_case.DeleteNoteUseCase
import com.example.note.domain.use_case.EditNoteUseCase
import com.example.note.domain.use_case.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase

) : BaseViewModel() {
    private val _addNoteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val addNoteState = _addNoteState.asStateFlow()

    private val _getAllNotesState = MutableStateFlow<UIState<List<NoteDto>>>(UIState.Loading())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    suspend fun addNote(noteDto: NoteDto) {
        addNoteUseCase.addNote(noteDto).getData({ error ->
            _addNoteState.value = UIState.Error(error ?: "Unknown message!")

        }, {
            _addNoteState.value = UIState.Loading()

        }, { data ->
            if (data != null)
                _addNoteState.value = Success(data)
        })

    }


    suspend fun getAllNotes() {
        getAllNotesUseCase.getAllNotes().getData(
            { error ->
                _getAllNotesState.value = UIState.Error(error ?: "Unknown message!")

            }, {
                _getAllNotesState.value = UIState.Loading()

            }, { data ->
                if (data != null)
                    _getAllNotesState.value = Success(data)

            })

    }
}
