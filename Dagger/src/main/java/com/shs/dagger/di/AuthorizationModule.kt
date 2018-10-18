package com.shs.dagger.di

import android.arch.lifecycle.ViewModel
import com.shs.dagger.data.OauthAuthorization
import com.shs.dagger.domain.Authorization
import com.shs.dagger.domain.AuthorizationUseCase
import com.shs.dagger.domain.IAuthorizationUseCase
import com.shs.dagger.presentation.AuthorizationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class AuthorizationModule {
	@Binds
	internal abstract fun bindAuthorization(oauthAuthorization: OauthAuthorization): Authorization

	@Binds
	internal abstract fun bindAuthorizationUseCase(useCase: AuthorizationUseCase): IAuthorizationUseCase

	@Binds
	@IntoMap
	@ViewModelKey(AuthorizationViewModel::class)
	internal abstract fun bindLaunchViewModel(viewModel: AuthorizationViewModel): ViewModel
}