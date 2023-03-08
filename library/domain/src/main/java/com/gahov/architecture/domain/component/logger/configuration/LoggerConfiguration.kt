package com.gahov.architecture.domain.component.logger.configuration

interface LoggerConfiguration {
    val className: String
    val isEnabled: Boolean

    fun copy(
        className: Any = this.className,
        isEnabled: Boolean = this.isEnabled
    ): LoggerConfiguration
}