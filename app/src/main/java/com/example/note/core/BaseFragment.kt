package com.example.note.core

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment: AppCompatActivity() {
    protected fun <T> StateFlow<UIState<T>>.subscribe(
        error: (message: String) -> Unit,
        loading: () -> Unit,
        succes: (data: T) -> Unit
    ){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
               this@subscribe.collect{
                    when(it){
                        is UIState.Error ->{
                            error(it.error)
                        }
                        is UIState.Loading ->{
                        loading
                        }
                        is UIState.Success ->{
                            succes(it.data)
                        }
                    }
                }
            }
        }
    }
}