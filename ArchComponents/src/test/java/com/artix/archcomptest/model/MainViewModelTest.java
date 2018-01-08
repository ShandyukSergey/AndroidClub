package com.artix.archcomptest.model;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.artix.archcomptest.TestApp;
import com.artix.archcomptest.injection.Injection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import io.reactivex.schedulers.Schedulers;

import static junit.framework.Assert.assertEquals;

/**
 * Created by User on 06.01.2018.
 */
public class MainViewModelTest {
	@Rule
	public TestRule taskExecutorRule = new InstantTaskExecutorRule();

	@Before
	public void setUp() throws Exception {
		TestApp.injection = new Injection(null);
	}

	@Test
	public void testInitialState() throws Exception {
		MainViewState defaultState = new MainViewState(LoadingStatus.IDLE, "test");
		MainViewModel viewModel = new MainViewModel(defaultState, Schedulers.trampoline(), Schedulers.trampoline());

		assertEquals("test", viewModel.getState().getValue().text);
		assertEquals(LoadingStatus.IDLE, viewModel.getState().getValue().status);
	}

	@Test
	public void testLoadingData() throws Exception {
		MainViewState defaultState = new MainViewState(LoadingStatus.IDLE, "test");
		MainViewModel viewModel = new MainViewModel(defaultState, Schedulers.trampoline(), Schedulers.trampoline());
		viewModel.loadSomething();

		assertEquals("test data", viewModel.getState().getValue().text);
		assertEquals(LoadingStatus.LOADED, viewModel.getState().getValue().status);
	}

	@Test
	public void testThatLoadingAlreadyRunning() throws Exception {
		MainViewState defaultState = new MainViewState(LoadingStatus.LOADING, "loading");
		MainViewModel viewModel = new MainViewModel(defaultState, Schedulers.trampoline(), Schedulers.trampoline());
		viewModel.loadSomething();

		assertEquals("loading", viewModel.getState().getValue().text);
		assertEquals(LoadingStatus.LOADING, viewModel.getState().getValue().status);
	}
}