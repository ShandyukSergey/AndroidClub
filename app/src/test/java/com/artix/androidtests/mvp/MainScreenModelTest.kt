package com.artix.androidtests.mvp

import com.artix.androidtests.app.TestsApplication
import com.artix.androidtests.injection.stub.DaggerTestApplicationComponent
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by User on 29.10.2017.
 */
class MainScreenModelTest {

    @Before
    fun setUp() {
        TestsApplication.injector = DaggerTestApplicationComponent.create()
    }

    @Test
    fun testLoadingItems() {
        val model = MainScreenModel()
        assertEquals(model.loadItems(), listOf("test"))
    }
}