package com.shs.dagger.presentation.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {
	@Inject
	internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
	@Inject
	internal lateinit var vmFactory: ViewModelProvider.Factory

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
	}

	override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
		return fragmentInjector
	}

	protected fun <VM : ViewModel> FragmentActivity.provideViewModel(viewModel: KClass<VM>) =
			ViewModelProviders.of(this, vmFactory).get(viewModel.java)
}