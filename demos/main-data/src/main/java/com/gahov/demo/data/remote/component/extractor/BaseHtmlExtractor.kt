package com.gahov.demo.data.remote.component.extractor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

abstract class BaseHtmlExtractor : HtmlExtractor {
    protected abstract val url: String

    final override suspend fun extract(args: Array<String>): JsonObject {
        return withContext(Dispatchers.IO) {
            extractor(args)
        }
    }

    abstract suspend fun extractor(args: Array<String>): JsonObject

    protected suspend fun fetchHtml(request: Request = getRequestBuilder().build()): String {
        val response = getOkHttpClient().newCall(
            request = request
        ).execute()
        val body = response.body
        

        response.close()

        return ""
    }

    protected fun getRequestBuilder() = Request.Builder().url(url)

    private fun getOkHttpClient() = OkHttpClient.Builder()
        .readTimeout(1000, TimeUnit.MILLISECONDS)
        .writeTimeout(1000, TimeUnit.MILLISECONDS)
        .build()
}