package com.artix.androidtests.injection.redux

import com.artix.androidtests.api.ApiClient
import com.artix.androidtests.redux.ReduxModelImpl
import com.artix.androidtests.redux.ReduxScreen
import com.artix.androidtests.redux.State
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers

/**
 * Created by User on 25.11.2017.
 */
@Module
class ReduxModule {

	@ReduxScope
	@Provides
	fun provideReduxModel(apiClient: ApiClient): ReduxScreen.Model =
			ReduxModelImpl(apiClient, State("", false), Schedulers.trampoline(), 0)
}