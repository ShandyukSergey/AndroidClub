package com.artix.androidtests.injection.stub

import com.artix.androidtests.api.ApiClient
import dagger.Module
import dagger.Provides

/**
 * Created by User on 29.10.2017.
 */
@Module
class TestApplicationModule {

    @Provides
    fun provideApiClient(): ApiClient = object : ApiClient {
        override fun loadData(): List<String> = listOf("test")
    }
}