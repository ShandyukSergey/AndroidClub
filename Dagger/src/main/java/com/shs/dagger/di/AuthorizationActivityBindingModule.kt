package com.shs.dagger.di

import android.app.Activity
import com.shs.dagger.presentation.AuthorizationActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [AuthorizationSubComponent::class])
internal abstract class AuthorizationActivityBindingModule {
	@Binds
	@IntoMap
	@ActivityKey(AuthorizationActivity::class)
	internal abstract fun bindAuthorizationActivityInjectorFactory(builder: AuthorizationSubComponent.Builder)
			: AndroidInjector.Factory<out Activity>
}