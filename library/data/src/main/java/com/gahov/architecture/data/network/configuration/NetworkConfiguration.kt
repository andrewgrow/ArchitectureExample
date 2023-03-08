package com.gahov.architecture.data.network.configuration

import com.gahov.architecture.data.network.configuration.convertor.ConverterFactoryProvider
import com.gahov.architecture.data.network.configuration.convertor.KotlinConverterFactory
import com.gahov.architecture.data.network.configuration.interceptor.utils.token.TokenProvider

sealed class NetworkConfiguration {
    abstract val server: String

    open val timeout: Long = 30L * 1000

    open val withLogs = true
    open val withAuth = false

    open val converterFactoryProvider: ConverterFactoryProvider = KotlinConverterFactory()

    abstract class AuthConfiguration(val tokenProvider: TokenProvider) : NetworkConfiguration() {
        override val withAuth: Boolean = true
    }
}