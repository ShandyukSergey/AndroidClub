package com.artix.archcomptest;

import android.app.Application;

import com.artix.archcomptest.injection.Injection;

/**
 * Created by User on 07.01.2018.
 */

public class TestApp extends Application {
	public static Injection injection;

	@Override
	public void onCreate() {
		super.onCreate();
		injection = new Injection(this);
	}
}
