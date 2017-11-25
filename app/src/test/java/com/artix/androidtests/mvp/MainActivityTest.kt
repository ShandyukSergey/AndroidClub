package com.artix.androidtests.mvp

import android.widget.Button
import android.widget.TextView
import com.artix.androidtests.R
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController


/**
 * Created by User on 28.10.2017.
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    private lateinit var activityController: ActivityController<MvpActivity>

    @Before
    fun setUp() {
        activityController = Robolectric.buildActivity(MvpActivity::class.java).create()
    }

    @Test
    fun testThatActivityWasAttached() {
        val activity = activityController.start().get()
        assertTrue(activity.presenter.isViewAttached())
    }

    @Test
    fun testThatActivityWasDetached() {
        val activity = activityController.start().stop().get()
        assertFalse(activity.presenter.isViewAttached())
    }

    @Test
    fun testThatItemsWasLoaded() {
        val activity = activityController.start().get()
        val button = activity.findViewById<Button>(R.id.btnLoad)
        val tvResult = activity.findViewById<TextView>(R.id.tvResult)
        button.performClick()

        assertEquals("A, B, C", tvResult.text)
    }

    @Ignore("verify doesn't work")
    @Test
    fun testThatPresenterStartLoading() {
        val activity = activityController.start().visible().get()
        val spyPresenter = spy(activity.presenter)
        val button = activity.findViewById<Button>(R.id.btnLoad)
        button.performClick()

        verify(spyPresenter).loadDataClicked()
    }
}