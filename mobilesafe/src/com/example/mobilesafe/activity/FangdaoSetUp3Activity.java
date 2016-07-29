package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FangdaoSetUp3Activity extends Activity {
private EditText eT_phone_security_num;
private Button bt_select_number;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fangdao_setup3);
		initUI();
}


private void 		initUI() {
	eT_phone_security_num = (EditText) findViewById(R.id.ET_phone_security_num);	
	bt_select_number = (Button) findViewById(R.id.bt_select_number);
	
	//绑定选择联系人按钮
	bt_select_number.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(), SelectContactListActivity.class);
			startActivityForResult(intent, 0);
		}
	});
}

//startActivityForResult 的回调。
@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (resultCode) {
		case 0:
			
			break;

		default:
			break;
		}
	}

/*
 *  点击下一页按钮
 */
public void nexBut(View view){
	Intent intent =new Intent(getApplicationContext(), FangdaoSetUp4Activity.class);
	startActivity(intent);
	finish();
}

public void lastBut(View view){
	Intent intent =new Intent(getApplicationContext(), FangdaoSetUp2Activity.class);
	startActivity(intent);
	finish();
}
}
