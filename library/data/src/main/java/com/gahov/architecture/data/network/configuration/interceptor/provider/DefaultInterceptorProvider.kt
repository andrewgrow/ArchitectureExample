package com.gahov.architecture.data.network.configuration.interceptor.provider

import com.gahov.architecture.data.network.configuration.NetworkConfiguration
import com.gahov.architecture.data.network.configuration.interceptor.TokenInterceptor
import com.gahov.architecture.data.network.configuration.interceptor.UserAgentInterceptor
import com.gahov.architecture.data.network.configuration.interceptor.utils.InterceptorLogger
import com.gahov.architecture.domain.component.device.UserAgentProvider
import com.gahov.architecture.domain.component.logger.Logger
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class DefaultInterceptorProvider(
    configuration: NetworkConfiguration,
    userAgentProvider: UserAgentProvider,
    logger: Logger
) : InterceptorProvider {

    override val networkInterceptors: ArrayList<Interceptor> = arrayListOf()
    override val interceptors: ArrayList<Interceptor> = arrayListOf()

    private val userAgentInterceptor: Interceptor by lazy { UserAgentInterceptor(userAgentProvider) }
    private val loggingInterceptor: Interceptor by lazy {
        HttpLoggingInterceptor(InterceptorLogger(logger))
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
    }

    init {
        networkInterceptors.add(userAgentInterceptor)

        if (configuration.withLogs) {
            networkInterceptors.add(loggingInterceptor)
        }

        if (configuration.withAuth && configuration is NetworkConfiguration.AuthConfiguration) {
            interceptors.add(TokenInterceptor(configuration))
        }

    }
}