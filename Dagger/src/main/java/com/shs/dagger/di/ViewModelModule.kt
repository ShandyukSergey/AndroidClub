package com.shs.dagger.di

import android.arch.lifecycle.ViewModelProvider
import com.shs.dagger.presentation.base.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
	@Binds
	internal abstract fun bindVmFactory(vmfactory: DaggerViewModelFactory): ViewModelProvider.Factory
}