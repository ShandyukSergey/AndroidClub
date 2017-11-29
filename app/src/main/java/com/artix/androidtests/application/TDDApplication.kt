package com.artix.androidtests.application

import android.app.Application
import com.artix.androidtests.injection.app.ApplicationComponent
import com.artix.androidtests.injection.app.DaggerApplicationComponent
import com.artix.androidtests.injection.redux.DaggerReduxComponent
import com.artix.androidtests.injection.redux.ReduxComponent

/**
 * Created by User on 29.10.2017.
 */
class TDDApplication : Application() {
	companion object {
		var applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
		private var reduxComponent: ReduxComponent? = null

		fun reduxComponent(): ReduxComponent {
			if (reduxComponent == null) {
				reduxComponent = DaggerReduxComponent.create()
				reduxComponent?.model()?.init()
			}
			return reduxComponent!!
		}

		fun releaseReduxComponent() {
			reduxComponent?.model()?.release()
			reduxComponent = null
		}
	}
}