package com.artix.androidtests.injection.stub

import com.artix.androidtests.api.ApiClient
import com.artix.androidtests.injection.ApplicationModule
import dagger.Provides

/**
 * Created by User on 29.10.2017.
 */
class TestApplicationModule : ApplicationModule() {

    override fun provideApiClient(): ApiClient = object : ApiClient {
        override fun loadData(): List<String> = listOf("test")
    }
}