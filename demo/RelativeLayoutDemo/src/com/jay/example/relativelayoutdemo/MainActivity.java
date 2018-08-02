package com.jay.example.relativelayoutdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Intent it = new Intent(MainActivity.this,AdActivity.class);
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					sleep(2000);
					startActivity(it);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();

	}
}
