package com.gahov.architecture.core.di

import com.gahov.architecture.core.BuildConfig
import com.gahov.architecture.core.component.device.LibDeviceInfo
import com.gahov.architecture.core.component.logger.AndroidLogger
import com.gahov.architecture.core.component.logger.configuration.DefaultLoggerConfiguration
import com.gahov.architecture.domain.component.device.DeviceInfo
import com.gahov.architecture.domain.component.device.UserAgent
import com.gahov.architecture.domain.component.device.UserAgentProvider
import com.gahov.architecture.domain.component.logger.Logger
import com.gahov.architecture.domain.component.logger.configuration.LoggerConfiguration
import org.koin.core.module.Module
import org.koin.dsl.module

val defaultLogger = module {
    factory<Logger> {
        AndroidLogger(configuration = get<LoggerConfiguration>())
    }
}

val defaultLoggerConfiguration = module {
    factory<LoggerConfiguration> {
        DefaultLoggerConfiguration(isEnabled = BuildConfig.DEBUG)
    }
}

val defaultUserAgent = module {
    single<UserAgentProvider> {
        UserAgent(deviceInfo = get<DeviceInfo>())
    }
}

val defaultDeviceInfo = module {
    single<DeviceInfo> {
        LibDeviceInfo()
    }
}

val defaultLoggerModule = listOf<Module>(defaultLoggerConfiguration, defaultLogger)
val defaultDeviceInfoModule = listOf<Module>(defaultDeviceInfo, defaultUserAgent)

val defaultDomainModule = defaultLoggerModule + defaultDeviceInfoModule
