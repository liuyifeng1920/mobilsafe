package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FangdaoSetUp1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fangdao_setup1);
	}
	
	public void nexBut(View view){
		Intent intent =new Intent(getApplicationContext(), FangdaoSetUp2Activity.class);
		startActivity(intent);
		finish();
	}
}
