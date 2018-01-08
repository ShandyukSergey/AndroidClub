package com.artix.archcomptest;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.artix.archcomptest.model.LoadingStatus;
import com.artix.archcomptest.model.MainViewModel;
import com.artix.archcomptest.model.MainViewState;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
	private TextView tvText;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.tvText = findViewById(R.id.tvText);
		this.progressBar = findViewById(R.id.progress);

		MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
		mainViewModel.getState().observe(this, new Observer<MainViewState>() {
			@Override
			public void onChanged(MainViewState vs) {
				renderState(vs);
			}
		});
		mainViewModel.loadSomething();
	}

	private void renderState(MainViewState vs) {
		this.tvText.setText(vs.text);
		this.progressBar.setVisibility(vs.status == LoadingStatus.LOADING ? VISIBLE : INVISIBLE);
		Log.d("shs", vs.text + " " + vs.status);
	}
}
