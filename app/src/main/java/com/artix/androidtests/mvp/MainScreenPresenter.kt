package com.artix.androidtests.mvp

open class MainScreenPresenter(private val model: MainScreen.Model) : MainScreen.Presenter {
    private var view: MainScreen.View? = null

    override fun attachView(view: MainScreen.View) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

    override fun isViewAttached(): Boolean = view != null

    override fun loadDataClicked() {
        view?.showProgress()
        view?.displayItems(model.loadItems())
        view?.hideProgress()
    }
}