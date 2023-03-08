package com.gahov.architecture.data.network.configuration.interceptor.utils

import com.gahov.architecture.domain.component.logger.Level
import com.gahov.architecture.domain.component.logger.Logger
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorLogger(private val logger: Logger) : HttpLoggingInterceptor.Logger {

    private val loggerConfiguration = logger.getConfiguration().copy(className = "Network")

    override fun log(message: String) {
        logger.log(
            level = Level.Info,
            message = message,
            configuration = loggerConfiguration
        )
    }
}
