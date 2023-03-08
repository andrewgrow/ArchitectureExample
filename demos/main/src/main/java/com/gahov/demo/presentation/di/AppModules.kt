package com.gahov.demo.presentation.di

import com.gahov.architecture.core.di.defaultDomainModule
import com.gahov.architecture.core.di.defaultPresentation

val appModule = defaultDomainModule + mvvm + useCase + defaultPresentation