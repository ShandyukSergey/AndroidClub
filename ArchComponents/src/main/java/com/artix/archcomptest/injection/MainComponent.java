package com.artix.archcomptest.injection;

import com.artix.archcomptest.model.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by User on 05.01.2018.
 */
@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
	void inject(MainViewModel mainViewModel);
}
