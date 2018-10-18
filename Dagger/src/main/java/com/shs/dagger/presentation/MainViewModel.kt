package com.shs.dagger.presentation

import android.arch.lifecycle.ViewModel
import com.shs.dagger.domain.GetUserInfoUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getUserInfoUseCase: GetUserInfoUseCase) : ViewModel() {
	fun getInfo(): String = getUserInfoUseCase.getInfo()
}