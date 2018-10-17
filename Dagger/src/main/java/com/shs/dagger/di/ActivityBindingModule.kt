package com.shs.dagger.di

import com.shs.dagger.presentation.AuthorizationActivity
import com.shs.dagger.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

	@ContributesAndroidInjector(modules = [MainModule::class])
	internal abstract fun contributeMainActivityInjector(): MainActivity

	@ContributesAndroidInjector(modules = [AuthorizationModule::class])
	internal abstract fun contributeAuthorizationActivityInjector(): AuthorizationActivity
}