package com.artix.androidtests.redux

import com.develop.zuzik.redux.core.store.Action

/**
 * Created by User on 25.11.2017.
 */
sealed class Action : Action {
	class Loading : com.artix.androidtests.redux.Action()
	class Loaded(val items: List<String>) : com.artix.androidtests.redux.Action()
}