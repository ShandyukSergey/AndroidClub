package com.artix.androidtests.redux

import com.artix.androidtests.application.TestsApplication
import com.develop.zuzik.redux.core.extension.asConsumer
import com.develop.zuzik.redux.core.model.ReduxPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by User on 25.11.2017.
 */
class ReduxPresenter : ReduxPresenter<ReduxScreen.View<State>>(), ReduxScreen.Presenter {
	@Inject
	lateinit var model: ReduxScreen.Model

	init {
		TestsApplication.reduxComponent().inject(this)
	}

	override fun onStart(view: ReduxScreen.View<State>) {
		intent(view.loadItems
				.subscribe(model.loadItemsAction.asConsumer()))
		intent(model
				.state
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe({ view.renderState(it) }))
	}
}