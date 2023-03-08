package com.gahov.demo.presentation.ui.main

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.gahov.architecture.R
import com.gahov.architecture.core.ui.activity.BaseActivity
import com.gahov.architecture.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    contentLayoutID = R.layout.activity_main
) {
    override val navController: NavController by lazy { findNavController(R.id.mainHostNavFragment) }
}