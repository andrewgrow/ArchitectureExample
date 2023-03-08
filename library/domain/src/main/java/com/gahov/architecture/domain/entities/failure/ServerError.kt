package com.gahov.architecture.domain.entities.failure

sealed class ServerError : Failure.FeatureFailure() {
    object ServerCommon : ServerError()
}