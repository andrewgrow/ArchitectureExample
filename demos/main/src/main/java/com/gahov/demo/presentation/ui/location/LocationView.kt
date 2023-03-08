package com.gahov.demo.presentation.ui.location

import com.gahov.architecture.core.ui.view.BaseView
import com.gahov.demo.presentation.ui.location.model.LocationModel

interface LocationView : BaseView {
    fun attachLocationModel(model: LocationModel)
}