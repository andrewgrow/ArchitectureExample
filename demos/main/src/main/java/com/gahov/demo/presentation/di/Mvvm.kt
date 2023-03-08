package com.gahov.demo.presentation.di

import com.gahov.demo.domain.usecase.PreLoadingUseCase
import com.gahov.demo.presentation.ui.location.LocationViewModel
import com.gahov.demo.presentation.ui.splash.SplashViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mvvm = module {
    viewModel<SplashViewModel> { SplashViewModel(preLoadingUseCase = PreLoadingUseCase()) }
    viewModel<LocationViewModel> { LocationViewModel() }
}