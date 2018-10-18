package com.shs.dagger.presentation

import android.arch.lifecycle.ViewModel
import com.shs.dagger.domain.AuthorizationUseCase
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(val authorizationUseCase: AuthorizationUseCase) : ViewModel()