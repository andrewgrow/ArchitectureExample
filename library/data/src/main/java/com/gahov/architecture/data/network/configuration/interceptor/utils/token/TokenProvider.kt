package com.gahov.architecture.data.network.configuration.interceptor.utils.token

interface TokenProvider {
    fun getToken(): String?
}