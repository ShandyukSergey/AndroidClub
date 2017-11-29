package com.artix.androidtests.redux

import com.artix.androidtests.redux.robot.ReduxViewRobot
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Created by User on 29.11.2017.
 * link = https://twitter.com/ThePracticalDev/status/845638950517706752
 */
class MviIntegrationTest {
	private lateinit var robot: ReduxViewRobot

	@Before
	fun setUp() {
		robot = ReduxViewRobot(ReduxPresenter(Schedulers.trampoline()))
		robot.setUp()
	}

	@After
	fun tearDown() {
		robot.tearDown()
	}

	@Test
	fun testInitialViewState() {
		robot.assertViewStateRendered(listOf(State("", false)))
	}

	@Test
	fun testLoadIntent() {
		robot.fireLoadItemsIntent()
		robot.assertViewStateRendered(
				listOf(
						State("", false),
						State("", true),
						State("test", false)))
	}
}