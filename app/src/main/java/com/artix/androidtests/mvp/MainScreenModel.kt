package com.artix.androidtests.mvp

import com.artix.androidtests.api.ApiClient
import com.artix.androidtests.app.AndroidTestsApplication
import javax.inject.Inject

class MainScreenModel : MainScreen.Model {
    @Inject
    lateinit var apiClient: ApiClient

    init {
        AndroidTestsApplication.injector.inject(this)
    }

    override fun loadItems(): List<String> = apiClient.loadData()
}