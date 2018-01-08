package com.artix.androidtests.redux

import com.develop.zuzik.redux.core.store.Reducer

/**
 * Created by User on 25.11.2017.
 */
class Reducer : Reducer<State> {

	override fun reduce(oldState: State, action: com.develop.zuzik.redux.core.store.Action): State {
		return (action as? Action)?.let {
			reduceState(oldState, it)
		} ?: oldState
	}

	private fun reduceState(oldState: State, action: Action): State = when (action) {
		is Action.Loading -> oldState.copy(loading = true)
		is Action.Loaded -> com.artix.androidtests.redux.State(action.items.joinToString(), false)
	}
}