package com.shs.dagger.di

import com.shs.dagger.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [
	AndroidInjectionModule::class,
	AuthorizationActivityBindingModule::class,
	MainActivityBindingModule::class
])
interface ApplicationComponent : AndroidInjector<App>