package com.artix.archcomptest.injection;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.artix.archcomptest.repo.TestRepository;
import com.artix.archcomptest.repo.TestRepositoryImpl;
import com.artix.archcomptest.room.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by User on 05.01.2018.
 */
@Module
public class MainModule {
	private final Context context;

	public MainModule(Context context) {
		this.context = context;
	}

	@Provides
	Context provideContext() {
		return this.context;
	}

	@Provides
	TestRepository provideTestRepository() {
		return new TestRepositoryImpl();
	}

	@Singleton
	@Provides
	AppDatabase provideAppDatabase(Context context) {
		return Room.databaseBuilder(context, AppDatabase.class, "database").build();
	}
}
