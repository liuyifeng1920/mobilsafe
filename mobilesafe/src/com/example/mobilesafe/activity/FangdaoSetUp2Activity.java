package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FangdaoSetUp2Activity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fangdao_setup2);
}
/*
 *  �����һҳ��ť
 */
public void nexBut(View view){
	Intent intent =new Intent(getApplicationContext(), FangdaoSetUp3Activity.class);
	startActivity(intent);
	finish();
}

public void lastBut(View view){
	Intent intent =new Intent(getApplicationContext(), FangdaoSetUp1Activity.class);
	startActivity(intent);
	finish();
}
}
