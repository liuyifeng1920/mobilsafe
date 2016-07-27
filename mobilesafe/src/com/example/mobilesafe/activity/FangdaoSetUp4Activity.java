package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;
import com.example.mobilesafe.utils.ContansValue;
import com.example.mobilesafe.utils.SpUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FangdaoSetUp4Activity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fangdao_setup4);
}


/*
 *  点击下一页按钮
 */
public void nexBut(View view){
	
	SpUtil.addBoolean(getApplicationContext(), ContansValue.SETUP_OVER, true);
	Intent intent =new Intent(getApplicationContext(), FangdaoActivity.class);
	startActivity(intent);
	finish();
}

public void lastBut(View view){
	Intent intent =new Intent(getApplicationContext(), FangdaoSetUp3Activity.class);
	startActivity(intent);
	finish();
}
}
