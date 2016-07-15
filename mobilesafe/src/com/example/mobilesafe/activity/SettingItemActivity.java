package com.example.mobilesafe.activity;

import com.example.mobilesafe.R;
import com.example.mobilesafe.utils.ContansValue;
import com.example.mobilesafe.utils.SpUtil;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingItemActivity extends RelativeLayout {
	private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.example.mobilesafe";
	private CheckBox cb_setting_is;
	private TextView setting_desc;
	private TextView setting_title;
	private String tag="SettingItemActivity";
	private String mDestitle;
	private String mDesoff;
	private String mDeson;
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
		
		initAttrs(attrs);
		setting_title.setText(mDestitle);
	}
private void initAttrs(AttributeSet attrs) {
	mDestitle = attrs.getAttributeValue(NAMESPACE, "destitle");
	mDesoff = attrs.getAttributeValue(NAMESPACE, "desoff");
	mDeson = attrs.getAttributeValue(NAMESPACE, "deson");
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
		SpUtil.addBoolean(getContext(), ContansValue.OPEN_UPDATE, !checked);
	}
	
	public void isCheck(Boolean boolean1){
		if(boolean1){
			cb_setting_is.setChecked(boolean1);
			setting_desc.setText("自动更新已开启");
			
		}else{
			cb_setting_is.setChecked(boolean1);
			setting_desc.setText("自动更新已关闭");
		}
	}
}
