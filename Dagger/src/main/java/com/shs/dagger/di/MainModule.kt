package com.shs.dagger.di

import com.shs.dagger.data.InMemoryUserRepository
import com.shs.dagger.domain.GetUserInfoUseCase
import com.shs.dagger.domain.IGetUserInfoUseCase
import com.shs.dagger.domain.UserRepository
import dagger.Binds
import dagger.Module

@Module
internal abstract class MainModule {
	@Binds
	internal abstract fun bindUserRepository(repo: InMemoryUserRepository): UserRepository

	@Binds
	internal abstract fun bindGetUserInfoUseCase(useCase: GetUserInfoUseCase): IGetUserInfoUseCase
}