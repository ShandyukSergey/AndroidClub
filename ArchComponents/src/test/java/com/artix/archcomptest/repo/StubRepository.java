package com.artix.archcomptest.repo;

import io.reactivex.Observable;

/**
 * Created by User on 05.01.2018.
 */

public class StubRepository implements TestRepository {
	private final String testResult;

	public StubRepository(String testResult) {
		this.testResult = testResult;
	}

	@Override
	public Observable<String> loadSomething() {
		return Observable.just(this.testResult);
	}
}
