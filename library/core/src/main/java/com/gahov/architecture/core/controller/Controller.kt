package com.gahov.architecture.core.controller

import com.gahov.architecture.core.router.command.Command
import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.architecture.domain.entities.failure.Failure

interface Controller {
    fun showMessage(message: TextProvider)

    fun setLoading(boolean: Boolean)

    fun navigate(command: Command)

    fun handleFailure(failure: Failure)

}