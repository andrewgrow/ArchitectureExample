package com.gahov.demo.presentation.ui.splash

import com.gahov.architecture.R
import com.gahov.architecture.core.controller.BaseViewModel
import com.gahov.architecture.core.ui.fragment.BaseFragment
import com.gahov.architecture.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>(
    contentLayoutID = R.layout.fragment_splash
), SplashView {
    private val viewModel by viewModel<SplashViewModel>()

    override fun getViewModel(): BaseViewModel = viewModel

}