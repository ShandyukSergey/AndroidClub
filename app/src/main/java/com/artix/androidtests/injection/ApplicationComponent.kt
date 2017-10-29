package com.artix.androidtests.injection

import com.artix.androidtests.mvp.MainScreenModel
import dagger.Component

/**
 * Created by User on 29.10.2017.
 */
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(model: MainScreenModel)
}