package com.artix.androidtests.injection.redux

import com.artix.androidtests.injection.app.ApiModule
import com.artix.androidtests.redux.ReduxPresenter
import com.artix.androidtests.redux.ReduxScreen
import dagger.Component

/**
 * Created by User on 25.11.2017.
 */
@ReduxScope
@Component(modules = arrayOf(ReduxModule::class, ApiModule::class))
interface ReduxComponent {

	fun inject(reduxPresenter: ReduxPresenter)

	fun model(): ReduxScreen.Model
}