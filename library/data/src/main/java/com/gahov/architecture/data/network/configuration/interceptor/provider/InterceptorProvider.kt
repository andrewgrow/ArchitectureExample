package com.gahov.architecture.data.network.configuration.interceptor.provider

import okhttp3.Interceptor

interface InterceptorProvider {
    val networkInterceptors: ArrayList<Interceptor>
    val interceptors: ArrayList<Interceptor>
}