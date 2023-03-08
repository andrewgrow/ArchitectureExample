package com.gahov.demo.presentation.ui.splash

import com.gahov.architecture.R
import com.gahov.architecture.core.controller.BaseViewModel
import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.architecture.domain.entities.OperationStatus
import com.gahov.architecture.domain.usecase.AsyncUseCase

class SplashViewModel(private val preLoadingUseCase: AsyncUseCase<OperationStatus>) :
    BaseViewModel() {

    init {
        initialization()
    }

    private fun initialization() {
        launch {
            val result = preLoadingUseCase.execute()
            result.fold(::handleFailure, ::handlePreLoadingResult)
        }
    }

    private fun handlePreLoadingResult(operationStatus: OperationStatus) {
        when (operationStatus) {
            OperationStatus.SUCCESS -> navigate(SplashFragmentDirections.actionSplashFragmentToLocationFragment())
            OperationStatus.FAILED -> showMessage(TextProvider.ResText(R.string.error_global))
        }
    }

}