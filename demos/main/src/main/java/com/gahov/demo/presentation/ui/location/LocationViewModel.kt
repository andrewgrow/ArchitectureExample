package com.gahov.demo.presentation.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gahov.architecture.core.controller.BaseViewModel
import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.demo.presentation.ui.location.model.LocationModel

class LocationViewModel : BaseViewModel(), LocationPresenter {

    private var locationData = LocationModel()

    private val _locationModel by lazy { MutableLiveData<LocationModel>(locationData) }
    val locationModel: LiveData<LocationModel>
        get() = _locationModel

    override fun onCardActionPressed() {
        showMessage(TextProvider.Text("Still in development"))
    }


}