package com.artix.archcomptest.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.artix.archcomptest.TestApp;
import com.artix.archcomptest.ext.NonNullLiveData;
import com.artix.archcomptest.repo.TestRepository;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by User on 05.01.2018.
 */

public class MainViewModel extends ViewModel {
	@Inject
	TestRepository testRepository;

	private final NonNullLiveData<MainViewState> state;
	private final CompositeDisposable disposable = new CompositeDisposable();

	private final Scheduler backgroundScheduler;
	private final Scheduler uiScheduler;

	public MainViewModel() {
		this(new MainViewState(LoadingStatus.IDLE, ""), Schedulers.io(), AndroidSchedulers.mainThread());
	}

	MainViewModel(MainViewState state, Scheduler backgroundScheduler, Scheduler uiScheduler) {
		TestApp.injection.mainComponent.inject(this);
		this.state = new NonNullLiveData<>(state);
		this.backgroundScheduler = backgroundScheduler;
		this.uiScheduler = uiScheduler;
	}

	public void loadSomething() {
		if (this.state.get().status == LoadingStatus.IDLE) {
			this.state.setValue(new MainViewState(LoadingStatus.LOADING, this.state.get().text));
			this.disposable.add(
					this.testRepository
							.loadSomething()
							.subscribeOn(this.backgroundScheduler)
							.observeOn(this.uiScheduler)
							.subscribe(
									new Consumer<String>() {
										@Override
										public void accept(String s) throws Exception {
											state.setValue(new MainViewState(LoadingStatus.LOADED, s));
										}
									},
									new Consumer<Throwable>() {
										@Override
										public void accept(Throwable throwable) throws Exception {
											state.setValue(new MainViewState(LoadingStatus.IDLE, throwable.toString()));
										}
									}));
		}
	}

	public final LiveData<MainViewState> getState() {
		return this.state;
	}

	@Override
	protected void onCleared() {
		super.onCleared();
		this.disposable.clear();
	}
}
