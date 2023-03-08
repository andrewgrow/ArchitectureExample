package com.gahov.demo.presentation.ui.location.model

import com.gahov.architecture.R
import com.gahov.architecture.core.ui.view.model.IconProvider
import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.demo.presentation.ui.view.card.CardModel

data class LocationModel(
    val locationPermission: CardModel = CardModel(
        icon = IconProvider.ResVectorIcon(R.drawable.ic_location),
        title = TextProvider.ResText(R.string.location_title),
        description = TextProvider.ResText(R.string.location_permission_description),
        buttonTitle = TextProvider.ResText(R.string.location_permission_accept)
    ),
    var currentLocation: TextProvider = TextProvider.FormatResText(res = R.string.location_description)
)