package com.mino.contactss.di.app

import android.app.Application
import com.mino.contactss.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@PerApplication
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        ViewModelsFactoryModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}