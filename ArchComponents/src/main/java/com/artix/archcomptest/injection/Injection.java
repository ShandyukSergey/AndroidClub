package com.artix.archcomptest.injection;

import android.content.Context;

/**
 * Created by User on 05.01.2018.
 */

public class Injection {
	public final MainComponent mainComponent;

	public Injection(Context context) {
		this.mainComponent =
				DaggerMainComponent
						.builder()
						.mainModule(new MainModule(context))
						.build();
	}
}
