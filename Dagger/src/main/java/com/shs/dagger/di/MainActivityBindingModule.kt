package com.shs.dagger.di

import com.shs.dagger.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBindingModule {

	@ContributesAndroidInjector(modules = [MainModule::class])
	internal abstract fun contributeMainActivityInjector(): MainActivity
}