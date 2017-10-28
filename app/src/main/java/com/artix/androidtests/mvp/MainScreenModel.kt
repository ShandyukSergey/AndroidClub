package com.artix.androidtests.mvp

class MainScreenModel : MainScreen.Model {
    override fun loadData(): List<String> = listOf("A", "B", "C")
}