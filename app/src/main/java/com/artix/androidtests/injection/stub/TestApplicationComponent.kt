package com.artix.androidtests.injection.stub

import com.artix.androidtests.injection.ApplicationComponent
import dagger.Component

/**
 * Created by User on 29.10.2017.
 */
@Component(modules = arrayOf(TestApplicationModule::class))
interface TestApplicationComponent : ApplicationComponent