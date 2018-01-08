package com.artix.androidtests.mvp

/**
 * Created by User on 28.10.2017.
 */
interface MainScreen {

    interface Model {
        fun loadItems(): List<String>
    }

    interface View {
        val presenter: Presenter

        fun showProgress()
        fun hideProgress()
        fun displayItems(items: List<String>)
    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun isViewAttached(): Boolean
        fun loadDataClicked()
    }
}