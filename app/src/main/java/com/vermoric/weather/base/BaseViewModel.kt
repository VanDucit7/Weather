package com.vermoric.weather.base

import androidx.lifecycle.ViewModel
import com.vermoric.weather.injection.component.DaggerViewModelInjector
import com.vermoric.weather.injection.component.ViewModelInjector
import com.vermoric.weather.injection.module.NetworkModule
import com.vermoric.weather.ui.PostListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}