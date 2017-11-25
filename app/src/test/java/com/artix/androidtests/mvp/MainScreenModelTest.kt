package com.artix.androidtests.mvp

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Created by User on 29.10.2017.
 */
class MainScreenModelTest {

	@Test
	fun testLoadingItems() {
		val model = MainScreenModel()
		assertEquals(listOf("test"), model.loadItems())
	}
}