package com.artix.androidtests.mvp

import com.artix.androidtests.api.ApiClient
import com.artix.androidtests.application.TDDApplication
import javax.inject.Inject

class MainScreenModel : MainScreen.Model {
    @Inject
    lateinit var apiClient: ApiClient

    init {
        TDDApplication.applicationComponent.inject(this)
    }

    override fun loadItems(): List<String> = apiClient.loadData()
}