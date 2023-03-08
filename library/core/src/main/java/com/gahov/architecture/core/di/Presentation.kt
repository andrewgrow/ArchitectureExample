package com.gahov.architecture.core.di

import com.gahov.architecture.core.component.error.DefaultFailureHandler
import com.gahov.architecture.core.component.error.ErrorHandler
import com.gahov.architecture.domain.component.logger.Logger
import org.koin.dsl.module

val defaultPresentation = module {
    factory<ErrorHandler> { DefaultFailureHandler(logger = get<Logger>()) }
}