package com.jay.example.relativelayoutdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class AdActivity extends Activity {

	private ImageView imgCancle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ad);
		imgCancle = (ImageView) findViewById(R.id.imgCancle);
		imgCancle.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				finish();		
			}
		});
	}
}
