package com.gahov.demo.data.remote.component.extractor

import kotlinx.serialization.json.JsonObject

interface HtmlExtractor {
    suspend fun extract(args: Array<String>): JsonObject
}