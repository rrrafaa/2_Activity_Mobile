package com.example.pam5.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count.asStateFlow()

    fun onClick(btn: String) {
        when (btn) {
            "up" -> _count.update { it + 1 }
            "down" -> _count.update { it - 1 }
            "reset" -> _count.value = 0
        }
        Log.d("COUNTER", "$btn -> ${_count.value}")
    }
}
