package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;
import com.example.mobilesafe.utils.ContansValue;
import com.example.mobilesafe.utils.SpUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FangdaoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Boolean setup_over = SpUtil.getBoolean(getApplicationContext(),
				ContansValue.SETUP_OVER, false);
		if (setup_over) {
			// 设置过初始化设置
			setContentView(R.layout.activity_fangdao_setup_over);
		} else {
			// 未设置过初始化设置
			Intent intent = new Intent(getApplicationContext(),
					FangdaoSetUp1Activity.class);
			startActivity(intent);
			finish();
		}

	}
}
