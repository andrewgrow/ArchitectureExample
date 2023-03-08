package com.gahov.demo.data.remote.source.location.extractor

import com.gahov.demo.data.remote.component.extractor.BaseHtmlExtractor
import kotlinx.serialization.json.JsonObject

class IpLocationExtractor : BaseHtmlExtractor() {
    override val url = "https://iplocation.com/"

    override suspend fun extractor(args: Array<String>): JsonObject {
        call(url)
    }
}