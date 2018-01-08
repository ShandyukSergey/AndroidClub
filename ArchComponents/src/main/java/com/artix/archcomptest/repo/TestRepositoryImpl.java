package com.artix.archcomptest.repo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by User on 05.01.2018.
 */

public class TestRepositoryImpl implements TestRepository {

	@Override
	public Observable<String> loadSomething() {
		return Observable.just("shs").delay(5, TimeUnit.SECONDS);
	}
}
