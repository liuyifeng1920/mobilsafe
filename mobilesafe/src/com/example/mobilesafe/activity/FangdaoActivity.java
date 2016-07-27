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
			// ���ù���ʼ������
			setContentView(R.layout.activity_fangdao_setup_over);
		} else {
			// δ���ù���ʼ������
			Intent intent = new Intent(getApplicationContext(),
					FangdaoSetUp1Activity.class);
			startActivity(intent);
			finish();
		}

	}
}
