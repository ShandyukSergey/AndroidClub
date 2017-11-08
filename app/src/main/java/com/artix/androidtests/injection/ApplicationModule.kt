package com.artix.androidtests.injection

import com.artix.androidtests.api.ApiClient
import com.artix.androidtests.api.ApiClientImpl
import dagger.Module
import dagger.Provides

/**
 * Created by User on 29.10.2017.
 */
@Module
open class ApplicationModule {

    @Provides
    open fun provideApiClient(): ApiClient = ApiClientImpl()
}