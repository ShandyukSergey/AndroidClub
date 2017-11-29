package com.artix.androidtests.redux

import com.develop.zuzik.redux.core.model.Redux
import io.reactivex.Observable
import io.reactivex.Observer

/**
 * Created by User on 25.11.2017.
 */
interface ReduxScreen {

	interface Model : Redux.Model<State> {
		val loadItemsAction: Observer<Any>
	}

	interface Presenter : Redux.Presenter<View<State>>

	interface View<in State> : Redux.View {
		val loadItemsIntent: Observable<Any>

		fun renderState(state: State)
	}
}