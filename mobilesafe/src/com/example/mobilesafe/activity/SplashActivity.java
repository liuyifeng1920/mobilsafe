package com.example.mobilesafe.activity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.example.mobilesafe.R;
import com.example.mobilesafe.R.id;
import com.example.mobilesafe.R.layout;
import com.example.mobilesafe.R.menu;
import com.example.mobilesafe.utils.StreamUtil;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class SplashActivity extends Activity {

	protected static final String tag = "SplashActivity";
	private TextView tv;
	private int localVersionNum;
	protected String mVersionDes;
	protected String mDownloadUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initUI();
		initDate();
		
		
	}
	/**
	 * 获取版本号空间
	 */
	private void initUI() {
		tv = (TextView)findViewById(R.id.tv_version_name);
		
	}

	/**
	 * 获取清单文件中的版本号
	 */
	private String getVersionName() {
		PackageManager pm=getPackageManager();
		try {
			PackageInfo packageInfo = pm.getPackageInfo(this.getPackageName(), 0);
			return packageInfo.versionName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	

	/**
	 *初始化数据
	 */
	/**
	 * 
	 */
	private void initDate() {
		tv.setText("版本名称"+getVersionName());
		//获取app本地版本号
		localVersionNum = getLocalVersionNum();
		
		//获取服务器端数据检测更新
		checkUpdate();
		
	}

	/**
	 * 检测服务器端更新
	 */
	private void checkUpdate() {
		//更新必须在子线程中进行
		new Thread(){

			public  void run(){
				try {
					URL url = new URL("http://10.0.2.2:8080/update74.json");
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();
					connection.setConnectTimeout(2000);
					connection.setReadTimeout(2000);
					
					if(connection.getResponseCode() == 200){
						//5,以流的形式,将数据获取下来
						InputStream is = connection.getInputStream();
						//6,将流转换成字符串(工具类封装)
						String json = StreamUtil.streamToString(is);
						Log.i(tag, json);
						//7,json解析
						JSONObject jsonObject = new JSONObject(json);
						
						//debug调试,解决问题
						String versionName = jsonObject.getString("versionName");
						mVersionDes = jsonObject.getString("versionDes");
						String versionCode = jsonObject.getString("versionCode");
						mDownloadUrl = jsonObject.getString("downloadUrl");

						//日志打印	
						Log.i(tag, versionName);
						Log.i(tag, mVersionDes);
						Log.i(tag, versionCode);
						Log.i(tag, mDownloadUrl);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
	}
	private int getLocalVersionNum() {

		PackageManager pm=getPackageManager();
		try {
			PackageInfo packageInfo = pm.getPackageInfo(this.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
