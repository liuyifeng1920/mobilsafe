package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingItemActivity extends RelativeLayout {

	private CheckBox cb_setting_is;
	private TextView setting_desc;
	private TextView setting_title;

	public SettingItemActivity(Context context) {
		this(context,null);
	}

	public SettingItemActivity(Context context, AttributeSet attrs) {
		this(context,attrs,0);
	}

	public SettingItemActivity(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle); 
		View view = View.inflate(context, R.layout.activity_setting_item, this);
		setting_title = (TextView) view.findViewById(R.id.tv_setting_title);
		setting_desc = (TextView) view.findViewById(R.id.tv_setting_desc);
		cb_setting_is = (CheckBox) view.findViewById(R.id.cb_setting_is);
	}
/*
 * 检查是否选中
 */
	public void  isCheck(){
		boolean checked = cb_setting_is.isChecked();
		if(checked){
			cb_setting_is.setChecked(!checked);
			setting_desc.setText("自动更新已关闭");
		}else{
			cb_setting_is.setChecked(!checked);
			setting_desc.setText("自动更新已开启");
		}
		
		
	}
	
}
