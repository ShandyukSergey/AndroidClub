package com.artix.archcomptest.ext;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

/**
 * Created by User on 06.01.2018.
 */

public class NonNullLiveData<T> extends LiveData<T> {

	public NonNullLiveData(@NonNull T defaultValue) {
		setValue(defaultValue);
	}

	@Override
	public void setValue(@NonNull T value) {
		super.setValue(value);
		checkForNull(value);
	}

	@Override
	protected void postValue(@NonNull T value) {
		super.postValue(value);
		checkForNull(value);
	}

	@NonNull
	public T get() {
		return super.getValue();
	}

	private void checkForNull(T value) {
		if (value == null) {
			throw new RuntimeException("value can't be null");
		}
	}
}
