package com.artix.archcomptest.injection;

import android.content.Context;
import android.support.annotation.Nullable;

import com.artix.archcomptest.repo.StubRepository;
import com.artix.archcomptest.repo.TestRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 05.01.2018.
 */
@Module
public class MainModule {

	public MainModule(@Nullable Context context) {
	}

	@Provides
	TestRepository provideTestRepository() {
		return new StubRepository("test data");
	}
}
