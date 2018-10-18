package com.shs.dagger.di

import com.shs.dagger.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
	AndroidSupportInjectionModule::class,
	AuthorizationActivityBindingModule::class,
	MainActivityBindingModule::class,
	ViewModelModule::class])
interface ApplicationComponent : AndroidInjector<App>