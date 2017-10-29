package com.artix.androidtests.app

import android.app.Application
import com.artix.androidtests.injection.ApplicationComponent
import com.artix.androidtests.injection.DaggerApplicationComponent

/**
 * Created by User on 29.10.2017.
 */
class AndroidTestsApplication : Application() {
    companion object {
        val injector: ApplicationComponent = DaggerApplicationComponent.create()
    }
}