package com.mino.contactss.di.app

import com.mino.contactss.di.main.MainModule
import com.mino.contactss.di.main.PerMain
import com.mino.contactss.ui.main.MainActivity
import com.mino.contactss.ui.main.viewmodel.ContactsViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @PerMain
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributesMainActivity(): MainActivity
}