package com.shs.dagger.di

import android.arch.lifecycle.ViewModel
import com.shs.dagger.data.InMemoryUserRepository
import com.shs.dagger.domain.GetUserInfoUseCase
import com.shs.dagger.domain.IGetUserInfoUseCase
import com.shs.dagger.domain.UserRepository
import com.shs.dagger.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {
	@Binds
	internal abstract fun bindUserRepository(repo: InMemoryUserRepository): UserRepository

	@Binds
	internal abstract fun bindGetUserInfoUseCase(useCase: GetUserInfoUseCase): IGetUserInfoUseCase

	@Binds
	@IntoMap
	@ViewModelKey(MainViewModel::class)
	internal abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}