package com.example.note.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.note.R

class MainActivity : AppCompatActivity() {

    private val viewModelWithExt:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       viewModelWithExt.addNoteLD.observe(this){

       }
    }
}