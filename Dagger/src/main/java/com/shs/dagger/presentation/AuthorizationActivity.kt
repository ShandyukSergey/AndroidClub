package com.shs.dagger.presentation

import android.content.Intent
import android.os.Bundle
import com.shs.dagger.R
import com.shs.dagger.domain.IAuthorizationUseCase
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class AuthorizationActivity : BaseActivity() {
	@Inject
	lateinit var authorizationUseCase: IAuthorizationUseCase

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)
		tvTitle.setOnClickListener {
			authorizationUseCase.authorize()
			startActivity(Intent(this, MainActivity::class.java))
		}
	}
}
