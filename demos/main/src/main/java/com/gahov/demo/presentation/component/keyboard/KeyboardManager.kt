package com.gahov.demo.presentation.component.keyboard

import com.gahov.architecture.domain.manager.Manager

interface KeyboardManager : Manager {
    fun onStart()

    fun onStop()

    fun addListener(keyboardListener: KeyboardListener)

    fun removeListener(keyboardListener: KeyboardListener)
}