package com.example.mobilesafe.activity;

import java.util.logging.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.mobilesafe.R;

public class SettingActivity extends Activity {

	public SettingActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		final SettingItemActivity itemActivity = (SettingItemActivity) findViewById(R.id.sia_Item_id);
		itemActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				itemActivity.isCheck();
			}
		});
	}
	
}
