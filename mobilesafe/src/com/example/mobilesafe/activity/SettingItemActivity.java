package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingItemActivity extends RelativeLayout {

	public SettingItemActivity(Context context) {
		this(context,null);
	}

	public SettingItemActivity(Context context, AttributeSet attrs) {
		this(context,attrs,0);
	}

	public SettingItemActivity(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle); 
		View view = View.inflate(context, R.layout.activity_setting_item, this);
		TextView setting_title=(TextView) view.findViewById(R.id.tv_setting_title);
		TextView setting_desc=(TextView) view.findViewById(R.id.tv_setting_desc);
		CheckBox textView=(CheckBox) view.findViewById(R.id.cb_setting_is);
	}

}
