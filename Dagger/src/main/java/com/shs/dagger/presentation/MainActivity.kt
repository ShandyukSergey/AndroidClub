package com.shs.dagger.presentation

import android.os.Bundle
import com.shs.dagger.R
import com.shs.dagger.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val viewModel = provideViewModel(MainViewModel::class)
		checkNotNull(viewModel)

		// can use vm
		tvTitle.text = viewModel.getInfo()
	}
}
