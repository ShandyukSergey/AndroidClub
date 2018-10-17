package com.shs.dagger.presentation

import android.os.Bundle
import com.shs.dagger.R
import com.shs.dagger.domain.IGetUserInfoUseCase
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
	@Inject
	lateinit var getUserInfoUseCase: IGetUserInfoUseCase

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		tvTitle.text = getUserInfoUseCase.getInfo()
	}
}
