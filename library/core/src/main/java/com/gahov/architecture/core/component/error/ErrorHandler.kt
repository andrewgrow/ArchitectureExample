package com.gahov.architecture.core.component.error

import com.gahov.architecture.domain.entities.failure.Failure

interface ErrorHandler {

    fun parseFailure(failure: Failure)

}