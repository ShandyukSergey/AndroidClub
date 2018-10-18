package com.shs.dagger.presentation

import android.content.Intent
import android.os.Bundle
import com.shs.dagger.R
import com.shs.dagger.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class AuthorizationActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_login)

		val viewModel = provideViewModel(AuthorizationViewModel::class)
		checkNotNull(viewModel)
		// can use vm

		tvTitle.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
	}

}
