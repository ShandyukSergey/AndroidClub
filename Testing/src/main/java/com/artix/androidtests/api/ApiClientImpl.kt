package com.artix.androidtests.api

class ApiClientImpl : ApiClient {
    override fun loadData(): List<String> = listOf("A", "B", "C")
}