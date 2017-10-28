package com.artix.androidtests.mvp

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by shs on 28.10.2017.
 */
@RunWith(MockitoJUnitRunner::class)
class PresenterTest {
    @Mock
    private lateinit var view: MainScreen.View
    @Mock
    private lateinit var model: MainScreen.Model

    private var presenter: MainScreen.Presenter? = null

    @Before
    fun setUp() {
        presenter = MainScreenPresenter(model)
    }

    @After
    fun tearDown() {
        presenter = null
    }

    @Test
    fun testAttachView() {
        presenter?.let { presenter ->
            presenter.attachView(view)
            assertTrue(presenter.isViewAttached())
        }
    }

    @Test
    fun testDetachView() {
        presenter?.let { presenter ->
            presenter.attachView(view)
            presenter.detachView()
            assertFalse(presenter.isViewAttached())
        }
    }

    @Test
    fun testLoadDataClicked() {
        presenter?.let { presenter ->
            `when`(model.loadData()).thenReturn(emptyList())

            presenter.attachView(view)
            presenter.loadDataClicked()

            verify(view).showProgress()
            verify(view).displayItems(anyList())
            verify(view).hideProgress()
        }
    }
}