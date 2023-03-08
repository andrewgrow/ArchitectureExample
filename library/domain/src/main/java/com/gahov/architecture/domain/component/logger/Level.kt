package com.gahov.architecture.domain.component.logger

sealed class Level {
    object Debug : Level()
    object Info : Level()
    object Warning : Level()
    object Error : Level()
}