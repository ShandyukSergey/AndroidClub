package com.artix.androidtests.mvp

import com.artix.androidtests.application.TestsApplication
import com.artix.androidtests.injection.DaggerApplicationComponent
import com.artix.androidtests.injection.stub.TestApplicationModule
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by User on 29.10.2017.
 */
class MainScreenModelTest {

    @Before
    fun setUp() {
        TestsApplication.injector =
                DaggerApplicationComponent
                        .builder()
                        .applicationModule(TestApplicationModule())
                        .build()
    }

    @After
    fun tearDown() {
        TestsApplication.injector = DaggerApplicationComponent.create()
    }

    @Test
    fun testLoadingItems() {
        val model = MainScreenModel()
        assertEquals(listOf("test"), model.loadItems())
    }
}