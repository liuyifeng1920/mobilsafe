package com.example.mobilesafe.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.mobilesafe.R;
import com.example.mobilesafe.utils.ContansValue;
import com.example.mobilesafe.utils.SpUtil;

public class FangdaoSetUp2Activity extends Activity {
private SettingItemActivity siv_sim_bound;

@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fangdao_setup2);
	intiUI();
}
private void intiUI() {
	siv_sim_bound = (SettingItemActivity)findViewById(R.id.siv_sim_bound);
	//ªÿœ‘
	String sim_num = SpUtil.getString(getApplicationContext(), ContansValue.SIM_NUM, "");
	if(TextUtils.isEmpty(sim_num)){
		siv_sim_bound.isCheck(false);
	}else{
		siv_sim_bound.isCheck(true);
	}
	
	siv_sim_bound.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			Boolean state = siv_sim_bound.getCheckState();
			if(!state){
				siv_sim_bound.isCheck(true);
				//¥Ê¥¢–Ú¡–ø®∫≈
				TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
				System.out.println("°æsimø®–Ú¡–∫≈°ø"+ContansValue.SIM_NUM);
				SpUtil.addString(getApplicationContext(), ContansValue.SIM_NUM, telephonyManager.getSimSerialNumber());
			}else{
				siv_sim_bound.isCheck(false);
				SpUtil.remove(getApplicationContext(),ContansValue.SIM_NUM);
			}
			
		}
	});
	
}
/*
 *  µ„ª˜œ¬“ª“≥∞¥≈•
 */
public void nexBut(View view){
	String sim_num = SpUtil.getString(getApplicationContext(), ContansValue.SIM_NUM, "");
	if(!TextUtils.isEmpty(sim_num)){
		Intent intent =new Intent(getApplicationContext(), FangdaoSetUp3Activity.class);
		startActivity(intent);
		finish();
	}else{
		Toast.makeText(getApplicationContext(), "«Î∞Û∂®simø®", Toast.LENGTH_SHORT).show();
	}
	
}

public void lastBut(View view){
	Intent intent =new Intent(getApplicationContext(), FangdaoSetUp1Activity.class);
	startActivity(intent);
	finish();
}
}
