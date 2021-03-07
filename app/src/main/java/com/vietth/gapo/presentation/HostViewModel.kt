package com.vietth.gapo.presentation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor(
    application: Application,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val isShowBottomNav: MutableLiveData<Boolean>
        get() = _isShowBottomNav
    private val _isShowBottomNav = MutableLiveData(true)

    fun showBottomNav() {
        _isShowBottomNav.value = true
    }

    fun hideBottomNav() {
        _isShowBottomNav.value = false
    }

}