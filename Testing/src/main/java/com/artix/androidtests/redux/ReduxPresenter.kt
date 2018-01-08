package com.artix.androidtests.redux

import com.artix.androidtests.application.TDDApplication
import com.develop.zuzik.redux.core.extension.asConsumer
import com.develop.zuzik.redux.core.model.ReduxPresenter
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by User on 25.11.2017.
 */
class ReduxPresenter(private val renderStateScheduler: Scheduler)
	: ReduxPresenter<ReduxScreen.View<State>>(), ReduxScreen.Presenter {

	@Inject
	lateinit var model: ReduxScreen.Model

	init {
		TDDApplication.reduxComponent().inject(this)
	}

	override fun onStart(view: ReduxScreen.View<State>) {
		intent(view
				.loadItemsIntent
				.subscribe(model.loadItemsAction.asConsumer()))
		intent(model
				.state
				.observeOn(renderStateScheduler)
				.subscribe({ view.renderState(it) }))
	}
}