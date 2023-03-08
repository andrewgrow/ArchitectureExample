package com.gahov.demo.presentation.ui.location

import android.os.Bundle
import android.view.View
import com.gahov.architecture.R
import com.gahov.architecture.core.controller.BaseViewModel
import com.gahov.architecture.core.ui.fragment.BaseFragment
import com.gahov.architecture.databinding.FragmentLocationBinding
import com.gahov.demo.presentation.ui.location.model.LocationModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding>(
    contentLayoutID = R.layout.fragment_location
), LocationView {
    private val viewModel by viewModel<LocationViewModel>()

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.presenter = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.locationModel.observe(viewLifecycleOwner, ::attachLocationModel)
    }

    override fun attachLocationModel(model: LocationModel) {
        binding.model = model
    }
}