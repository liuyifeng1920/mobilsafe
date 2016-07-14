package com.example.mobilesafe.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtil {

	private static SharedPreferences sharedPreferences;
	
	public static void addBoolean(Context context,String key,Boolean value){
		if(sharedPreferences==null){
			sharedPreferences=context.getSharedPreferences("config", Context.MODE_PRIVATE);
		}
		sharedPreferences.edit().putBoolean(key, value).commit();
	}

	public static Boolean getBoolean(Context context,String key,Boolean defBoolean){
		if(sharedPreferences==null){
			sharedPreferences=context.getSharedPreferences("config", Context.MODE_PRIVATE);
		}
		return sharedPreferences.getBoolean(key, defBoolean);
	}
}
