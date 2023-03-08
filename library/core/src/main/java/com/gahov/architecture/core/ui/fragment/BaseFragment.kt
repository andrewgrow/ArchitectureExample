package com.gahov.architecture.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gahov.architecture.core.component.error.ErrorHandler
import com.gahov.architecture.core.controller.BaseViewModel
import com.gahov.architecture.core.ktx.getString
import com.gahov.architecture.core.ktx.hideKeyboard
import com.gahov.architecture.core.provider.RouterProvider
import com.gahov.architecture.core.router.NavComponentRouter
import com.gahov.architecture.core.router.Router
import com.gahov.architecture.core.router.command.Command
import com.gahov.architecture.core.router.command.NavDirection
import com.gahov.architecture.core.ui.view.BaseView
import com.gahov.architecture.core.ui.view.model.TextProvider
import com.gahov.architecture.domain.component.logger.Level
import com.gahov.architecture.domain.component.logger.Logger
import com.gahov.architecture.domain.entities.failure.Failure
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes private val contentLayoutID: Int
) : Fragment(), BaseView, RouterProvider {

    protected lateinit var binding: T
        private set

    protected val logger: Logger by inject { parametersOf(this) }
    private val errorHandler: ErrorHandler by inject()

    override val router: Router by lazy {
        NavComponentRouter(
            navController = findNavController(),
            logger = logger
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, contentLayoutID, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setBaseObservers()
        setObservers()
    }

    override fun onPause() {
        super.onPause()
        hideKeyboard()
    }

    protected open fun navigate(command: Command) {
        when (command) {
            is NavDirection -> router.navigate(command)
            Command.Back -> router.popBackStack()
            Command.Root -> router.popToRoot()
            Command.Close -> requireActivity().finish()
            is Command.FeatureCommand -> navigateByFeature(command)
            is Command.Route -> commandError(command)
        }
    }

    protected open fun setBaseObservers() {
        getViewModel()?.let {
            it.errorEvent.observe(viewLifecycleOwner, ::displayError)
            it.navigationCommand.observe(viewLifecycleOwner, ::navigate)
            it.message.observe(viewLifecycleOwner, ::showMessage)
        }
    }

    protected open fun navigateByFeature(command: Command.FeatureCommand) {
        logger.log(
            level = Level.Warning,
            message = "method navigateByFeature isn't implement for $command"
        )
    }

    private fun commandError(command: Command) {
        logger.log(
            level = Level.Warning,
            message = "navigation isn't implement for $command"
        )
    }

    protected open fun setObservers() {}

    protected open fun getViewModel(): BaseViewModel? {
        return null
    }

    override fun displayError(failure: Failure) {
        errorHandler.parseFailure(failure)
    }

    override fun showMessage(textProvider: TextProvider) {
        context?.let { context ->
            Toast.makeText(
                context.applicationContext,
                textProvider.getString(context),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}