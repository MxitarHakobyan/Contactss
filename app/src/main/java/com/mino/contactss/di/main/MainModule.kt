package com.mino.contactss.di.main

import androidx.lifecycle.ViewModel
import com.mino.contactss.di.app.ViewModelKey
import com.mino.contactss.ui.main.viewmodel.ContactsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(ContactsViewModel::class)
    abstract fun bindUrlViewModel(viewModel: ContactsViewModel): ViewModel
}