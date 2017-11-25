package com.artix.androidtests.redux

import com.artix.androidtests.application.TestsApplication
import io.reactivex.observers.TestObserver
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by User on 25.11.2017.
 */
class ReduxModelTest {
	var model: ReduxScreen.Model? = null

	@Before
	fun setUp() {
		model = TestsApplication.reduxComponent().model()
	}

	@After
	fun tearDown() {
		TestsApplication.releaseReduxComponent()
		model = null
	}

	@Test
	fun testInitialState() {
		val testObserver = TestObserver.create<State>()
		model?.state?.subscribe(testObserver)
		testObserver.assertValue(State("", false))
	}

	@Test
	fun testLoadAction() {
		val testObserver = TestObserver.create<State>()
		model?.state?.subscribe(testObserver)
		model?.loadItemsAction?.onNext(Any())
		testObserver.awaitCount(3)
		testObserver.assertValues(
				State("", false),
				State("", true),
				State("test", false))
	}
}