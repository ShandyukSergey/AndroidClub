package com.shs.dagger.di

import com.shs.dagger.presentation.AuthorizationActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [AuthorizationModule::class])
interface AuthorizationSubComponent : AndroidInjector<AuthorizationActivity> {
	@Subcomponent.Builder
	abstract class Builder : AndroidInjector.Builder<AuthorizationActivity>()
}