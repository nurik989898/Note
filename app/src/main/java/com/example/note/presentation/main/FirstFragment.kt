package com.example.note.presentation.main


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.note.R
import com.example.note.core.BaseFragment
import com.example.note.core.UIState
import com.example.note.data.model.NoteDto
import com.example.note.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstFragment : BaseFragment() {
    private val viewModel: MainViewModel by viewModels()

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getAllNotes()
        var i = 0
        findViewById<Button>(R.id.btn_tab).setOnClickListener {
            viewModel.addNote(NoteDto(title = (++i).toString(), description = (++i).toString()))
        }

                viewModel.addNoteState.subscribe({
                error->
                    Toast.makeText(this,error, Toast.LENGTH_SHORT).show()
                },{
                //TODO show progress bar
                },{
                    viewModel.getAllNotes()
                }
                )
                viewModel.getAllNotesState.subscribe({ error->
                    Toast.makeText(this,error, Toast.LENGTH_SHORT)
                },{
                    //TODO show progress bar
                },{data->
                    findViewById<TextView>(R.id.tv_notes).text = data.toString()
                })
    }
}

