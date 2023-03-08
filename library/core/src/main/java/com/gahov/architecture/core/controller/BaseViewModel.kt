package com.gahov.architecture.core.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.gahov.architecture.core.coroutine.CoroutineLauncher
import com.gahov.architecture.core.coroutine.impl.DefaultCoroutineLauncher
import com.gahov.architecture.core.lifecycle.SingleLiveEvent
import com.gahov.architecture.core.provider.CoroutineProvider
import com.gahov.architecture.core.router.command.Command
import com.gahov.architecture.core.router.command.NavDirection
import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.architecture.domain.entities.failure.Failure
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel : ViewModel(), Controller, CoroutineProvider {

    override val launcher: CoroutineLauncher by lazy {
        DefaultCoroutineLauncher(
            viewModelScope,
            ::handleFailure
        )
    }

    private val _message by lazy { SingleLiveEvent<TextProvider>() }
    val message: LiveData<TextProvider>
        get() = _message

    private val _errorEvent by lazy { SingleLiveEvent<Failure>() }
    val errorEvent: LiveData<Failure>
        get() = _errorEvent

    private val _isLoading by lazy { MutableLiveData(false) }
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _navigationCommand by lazy { SingleLiveEvent<Command>() }
    val navigationCommand: LiveData<Command>
        get() = _navigationCommand

    fun launch(block: suspend CoroutineScope.() -> Unit) = launcher.launch(block = block)

    override fun showMessage(message: TextProvider) {
        _message.value = message
    }

    override fun setLoading(boolean: Boolean) {
        _isLoading.value = boolean
    }

    override fun navigate(command: Command) {
        _navigationCommand.value = command
    }

    fun navigate(directions: NavDirections) {
        navigate(NavDirection.Direction(directions))
    }

    override fun handleFailure(failure: Failure) {
        if (failure is Failure.FeatureFailure) {
            handleFailureFeature(failure)
        } else {
            _errorEvent.postValue(failure)
        }
    }

    protected open fun handleFailureFeature(failure: Failure.FeatureFailure) {
        _errorEvent.postValue(failure)
    }
}
