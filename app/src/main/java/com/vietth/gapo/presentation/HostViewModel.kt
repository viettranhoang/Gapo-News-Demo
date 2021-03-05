package com.vietth.gapo.presentation

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor(
    application: Application,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

}