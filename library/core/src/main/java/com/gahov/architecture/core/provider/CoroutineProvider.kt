package com.gahov.architecture.core.provider

import com.gahov.architecture.core.coroutine.CoroutineLauncher

interface CoroutineProvider {
    val launcher: CoroutineLauncher
}