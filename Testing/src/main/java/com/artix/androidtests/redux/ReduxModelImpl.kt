package com.artix.androidtests.redux

import com.artix.androidtests.api.ApiClient
import com.develop.zuzik.redux.core.model.ReduxModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class ReduxModelImpl(
		val apiClient: ApiClient,
		defaultState: State,
		scheduler: Scheduler,
		val loadingDelaySec: Long)
	: ReduxScreen.Model, ReduxModel<State>(defaultState, scheduler) {

	override val loadItemsAction: PublishSubject<Any> = PublishSubject.create()

	init {
		addAction(
				loadItemsAction
						.flatMap { loadData() }
						.subscribeOn(scheduler))
		addReducer(Reducer())
	}

	private fun loadData(): Observable<com.develop.zuzik.redux.core.store.Action> {
		return Observable
				.just(apiClient.loadData())
				.delay(loadingDelaySec, TimeUnit.SECONDS)
				.map<com.develop.zuzik.redux.core.store.Action> { Action.Loaded(it) }
				.startWith(Action.Loading())
	}
}