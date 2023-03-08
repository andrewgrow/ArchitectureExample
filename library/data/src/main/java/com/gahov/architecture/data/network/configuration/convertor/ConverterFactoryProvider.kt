package com.gahov.architecture.data.network.configuration.convertor

import retrofit2.Converter

interface ConverterFactoryProvider {
    val converterFactory: Converter.Factory
}