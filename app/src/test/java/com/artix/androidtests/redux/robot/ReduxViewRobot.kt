package com.artix.androidtests.redux.robot

import com.artix.androidtests.application.TDDApplication
import com.artix.androidtests.redux.ReduxPresenter
import com.artix.androidtests.redux.ReduxScreen
import com.artix.androidtests.redux.State
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import junit.framework.Assert


/**
 * Created by User on 29.11.2017.
 */
class ReduxViewRobot(private val presenter: ReduxPresenter) {
	private val loadItemsSubject = PublishSubject.create<Any>()
	private val renderEvents: MutableList<State> = mutableListOf()

	private val view: ReduxScreen.View<State> = object : ReduxScreen.View<State> {
		override val loadItemsIntent: Observable<Any>
			get() = loadItemsSubject

		override fun renderState(state: State) {
			renderEvents += state
		}
	}

	fun setUp() {
		presenter.onStart(view)
	}

	fun tearDown() {
		presenter.onStop()
		TDDApplication.releaseReduxComponent()
	}

	fun fireLoadItemsIntent() {
		loadItemsSubject.onNext(Any())
	}

	fun assertViewStateRendered(states: List<State>) {
		Assert.assertEquals(states, renderEvents)
	}
}