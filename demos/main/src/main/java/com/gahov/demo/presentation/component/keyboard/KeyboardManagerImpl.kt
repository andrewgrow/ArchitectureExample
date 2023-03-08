package com.gahov.demo.presentation.component.keyboard

import android.app.Activity
import android.graphics.Rect
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.collection.ArraySet

class KeyboardManagerImpl(
    private val activity: Activity,
    private val rootView: ViewGroup
) : KeyboardManager {

    private val keyboardListeners = ArraySet<KeyboardListener>()
    private var state = KeyboardState.CLOSED

    private val keyboardLayoutListener = OnGlobalLayoutListener {
        val visibleBounds = Rect()
        activity.window.decorView.getWindowVisibleDisplayFrame(visibleBounds)

        val screenHeight = rootView.height
        val keypadHeight = screenHeight - visibleBounds.bottom

        val updatedState = if (keypadHeight > screenHeight * 0.15) {
            KeyboardState.OPENED
        } else {
            KeyboardState.CLOSED
        }

        if (updatedState != state) {
            when (updatedState) {
                KeyboardState.OPENED -> keyboardListeners.forEach { it.onOpened() }
                KeyboardState.CLOSED -> keyboardListeners.forEach { it.onClosed() }
            }
        }

        state = updatedState
    }

    override fun onStart() {
        rootView.viewTreeObserver.addOnGlobalLayoutListener(keyboardLayoutListener)
    }

    override fun onStop() {
        rootView.viewTreeObserver.removeOnGlobalLayoutListener(keyboardLayoutListener)
    }

    override fun addListener(keyboardListener: KeyboardListener) {
        keyboardListeners.add(keyboardListener)
    }

    override fun removeListener(keyboardListener: KeyboardListener) {
        keyboardListeners.remove(keyboardListener)
    }
}