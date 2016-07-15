package com.example.mobilesafe.activity;

import java.util.logging.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.mobilesafe.R;
import com.example.mobilesafe.utils.ContansValue;
import com.example.mobilesafe.utils.SpUtil;

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
		
		Boolean isCheck = SpUtil.getBoolean(this, ContansValue.OPEN_UPDATE, false);
		itemActivity.isCheck(isCheck);
		
		itemActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				itemActivity.isCheck();
			}
		});
	}
	
}
