package com.artix.androidtests.mvp

import com.artix.androidtests.api.ApiClient
import com.artix.androidtests.application.TestsApplication
import javax.inject.Inject

class MainScreenModel : MainScreen.Model {
    @Inject
    lateinit var apiClient: ApiClient

    init {
        TestsApplication.injector.inject(this)
    }

    override fun loadItems(): List<String> = apiClient.loadData()
}