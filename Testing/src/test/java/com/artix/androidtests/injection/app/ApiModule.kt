package com.artix.androidtests.injection.app

import com.artix.androidtests.api.ApiClient

/**
 * Created by User on 29.10.2017.
 */
class ApiModule {
	fun provideApiClient(): ApiClient = object : ApiClient {
		override fun loadData(): List<String> = listOf("test")
	}
}