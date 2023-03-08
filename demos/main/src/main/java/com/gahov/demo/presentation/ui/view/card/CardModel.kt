package com.gahov.demo.presentation.ui.view.card

import com.gahov.architecture.core.ui.view.model.IconProvider
import com.gahov.architecture.core.ui.view.model.TextProvider

data class CardModel(
    val icon: IconProvider,
    val title: TextProvider,
    val description: TextProvider,
    val buttonTitle: TextProvider
)
