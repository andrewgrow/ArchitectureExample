package com.gahov.architecture.core.di

import com.gahov.architecture.data.network.configuration.NetworkConfiguration
import com.gahov.architecture.data.network.configuration.interceptor.provider.DefaultInterceptorProvider
import com.gahov.architecture.data.network.configuration.interceptor.provider.InterceptorProvider
import com.gahov.architecture.domain.component.device.UserAgentProvider
import com.gahov.architecture.domain.component.logger.Logger
import org.koin.dsl.module

val defaultInterceptor = module {
    single<InterceptorProvider> {
        DefaultInterceptorProvider(
            configuration = get<NetworkConfiguration>(),
            userAgentProvider = get<UserAgentProvider>(),
            logger = get<Logger>()
        )
    }
}