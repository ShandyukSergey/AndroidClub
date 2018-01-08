package com.artix.archcomptest.model;

/**
 * Created by User on 05.01.2018.
 */

public class MainViewState {
	public final LoadingStatus status;
	public final String text;

	public MainViewState(LoadingStatus status, String text) {
		this.status = status;
		this.text = text;
	}
}
