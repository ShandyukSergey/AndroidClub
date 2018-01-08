package com.artix.archcomptest.repo;


import io.reactivex.Observable;

/**
 * Created by User on 05.01.2018.
 */

public interface TestRepository {
	Observable<String> loadSomething();
}
