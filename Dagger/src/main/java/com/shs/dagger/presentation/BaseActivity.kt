package com.shs.dagger.presentation

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : Activity(), HasFragmentInjector {
	@Inject
	internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
	}

	override fun fragmentInjector(): AndroidInjector<Fragment>? {
		return fragmentInjector
	}
}