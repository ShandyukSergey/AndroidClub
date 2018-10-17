package com.shs.dagger.di

import com.shs.dagger.data.OauthAuthorization
import com.shs.dagger.domain.Authorization
import com.shs.dagger.domain.AuthorizationUseCase
import com.shs.dagger.domain.IAuthorizationUseCase
import dagger.Binds
import dagger.Module

@Module
internal abstract class AuthorizationModule {
	@Binds
	internal abstract fun bindAuthorization(oauthAuthorization: OauthAuthorization): Authorization

	@Binds
	internal abstract fun bindAuthorizationUseCase(useCase: AuthorizationUseCase): IAuthorizationUseCase
}