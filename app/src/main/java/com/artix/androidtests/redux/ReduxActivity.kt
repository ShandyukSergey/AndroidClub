package com.artix.androidtests.redux

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.artix.androidtests.R
import com.artix.androidtests.application.TestsApplication
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class ReduxActivity : AppCompatActivity() {
	private val presenter = ReduxPresenter()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onStart() {
		super.onStart()
		presenter.onStart(object : ReduxScreen.View<State> {
			override val loadItems: Observable<Any>
				get() = btnLoad.clicks().map { Any() }

			override fun renderState(state: State) {
				progressBar.visibility = if (state.loading) View.VISIBLE else View.GONE
				tvResult.text = state.itemsResult
			}
		})
	}

	override fun onStop() {
		presenter.onStop()
		super.onStop()
	}

	override fun onDestroy() {
		super.onDestroy()
		if (!isChangingConfigurations) {
			TestsApplication.releaseReduxComponent()
		}
	}
}