package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SelectContactListActivity extends Activity {
	private ListView lV_select_contact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_contact_list);
	
	intiUI();
	intiData();
	}
	
	/**
	 * ��ʼ������
	 */
	private void intiData() {
		
	}

	/**
	 * ��ʼ��UI�ؼ�
	 */
	private void intiUI() {
	lV_select_contact = (ListView) findViewById(R.id.LV_select_contact);
	}
}
