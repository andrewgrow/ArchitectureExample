package com.gahov.architecture.core.ui.view

import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.architecture.domain.entities.failure.Failure

interface BaseView {
    fun displayError(failure: Failure)

    fun showMessage(textProvider: TextProvider)
}