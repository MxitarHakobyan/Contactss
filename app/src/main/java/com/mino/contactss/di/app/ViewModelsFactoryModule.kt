package com.mino.contactss.di.app

import androidx.lifecycle.ViewModelProvider
import com.mino.contactss.ui.common.viewmodels_factory.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelsFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProvider: ViewModelsProviderFactory): ViewModelProvider.Factory
}