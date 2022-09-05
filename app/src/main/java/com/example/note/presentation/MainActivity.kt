package com.example.note.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.note.R
import com.example.note.core.UIState
import com.example.note.data.model.Note
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getAllNotes()
        var i = 0
        findViewById<Button>(R.id.btn_tab).setOnClickListener {
            viewModel.addNote(Note(title = (++i).toString(), description = (++i).toString()))
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
             viewModel.addNoteState.collect{
                 when(it){
                     is UIState.Error ->{
                         Toast.makeText(this@MainActivity,it.error,Toast.LENGTH_SHORT).show()
                     }
                     is UIState.Loading ->{

                     }
                     is UIState.Success ->{
                        viewModel.getAllNotes()
                     }
                 }
             }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllNotesState.collect{
                    when(it){
                        is UIState.Error ->{
                            Toast.makeText(this@MainActivity,it.error,Toast.LENGTH_SHORT)
                        }
                        is UIState.Loading ->{

                        }
                        is UIState.Success ->{
                            findViewById<TextView>(R.id.tv_notes).text = it.data.toString()
                        }
                    }
                }
            }
        }
        viewModel.getAllNotesState
    }
}