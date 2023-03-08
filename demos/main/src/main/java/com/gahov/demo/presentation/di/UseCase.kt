package com.gahov.demo.presentation.di

import com.gahov.demo.domain.usecase.PreLoadingUseCase
import org.koin.dsl.module

val useCase = module {
    factory<PreLoadingUseCase> { PreLoadingUseCase() }
}