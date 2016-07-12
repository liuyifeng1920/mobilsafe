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
import com.example.mobilesafe.utils.ToastUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
	protected static final int OPEN_WINDOWS = 0;
	protected static final int ENTRY_HOMEACTIVITY = 1;
	private TextView tv;
	private int localVersionNum;
	protected String mVersionDes;
	protected String mDownloadUrl;
	private RelativeLayout rl_root;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initUI();
		initDate();
		
		//���䶯��С˵
		initAnimation();
		
	}
	
	/**
	 * ��������Ч����homeҳ
	 */
	private void initAnimation() {
		AlphaAnimation alphaAnimation =new AlphaAnimation(0, 1);
		alphaAnimation.setDuration(5000);//����ʱ��
		rl_root.startAnimation(alphaAnimation);
	}
	//���̴߳�����Ϣ
	Handler handler =new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case OPEN_WINDOWS:
				//���������Ի���
				showUpdateDialog();
				break;
			case ENTRY_HOMEACTIVITY:
				//������ҳ
				enteyHomeActivity();	
				ToastUtil.show(SplashActivity.this, "������ҳ");
				break;

			default:
				enteyHomeActivity();	
				break;
			}
		};
	};
	protected Message message;
	
	/**
	 * ��ȡ�汾�ſռ�
	 */
	private void initUI() {
		tv = (TextView)findViewById(R.id.tv_version_name);
		rl_root = (RelativeLayout) findViewById(R.id.rl_root);
	}
	
	protected void showUpdateDialog() {
		Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("�Ƿ�������");
		builder.setPositiveButton("��������"	, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				enteyHomeActivity();
				
			}
		});
		
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				enteyHomeActivity();
				
			}
		});
		builder.show();
	}
	//������ҳ
	protected void enteyHomeActivity() {
		Intent intent = new Intent(this, HomeActivity.class);
		startActivity(intent);
		//�ر���һ��
		finish();
		
	}

	/**
	 * ��ȡ�嵥�ļ��еİ汾��
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
	 *��ʼ������
	 */
	/**
	 * 
	 */
	private void initDate() {
		tv.setText("�汾����"+getVersionName());
		//��ȡapp���ذ汾��
		localVersionNum = getLocalVersionNum();
		
		//��ȡ�����������ݼ�����
		checkUpdate();
		
	}

	/**
	 * ���������˸���
	 */
	private void checkUpdate() {
		//���±��������߳��н���
		new Thread(){
			
			public  void run(){
				long startUpdataTime = java.lang.System.currentTimeMillis();
				 message = Message.obtain();
				try {
					/*URL url = new URL("http://192.168.1.6:8080/json.json");
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();
					connection.setConnectTimeout(2000);
					connection.setReadTimeout(2000);
					
					if(connection.getResponseCode() == 200){
						//5,��������ʽ,�����ݻ�ȡ����
						InputStream is = connection.getInputStream();
						//6,����ת�����ַ���(�������װ)
						String json = StreamUtil.streamToString(is);
						Log.i(tag, json);
						//7,json����
						JSONObject jsonObject = new JSONObject(json);
						
						//debug����,�������
						String versionName = jsonObject.getString("versionName");
						mVersionDes = jsonObject.getString("versionDes");
						String versionCode = "5"jsonObject.getString("versionCode");
						mDownloadUrl = jsonObject.getString("downloadUrl");

						//��־��ӡ	
						Log.i(tag, versionName);
						Log.i(tag, mVersionDes);
						Log.i(tag, versionCode);
						Log.i(tag, mDownloadUrl);*/
						//8 �ȶ԰汾��
						if(localVersionNum<Integer.parseInt("2")){
							//����������ʾ��
							message.what=OPEN_WINDOWS;
						}else{
							//����������
							message.what=ENTRY_HOMEACTIVITY;
						}
//					}
				} catch (Exception e) {
					e.printStackTrace();
					
					
				}finally{
					
					if(startUpdataTime-java.lang.System.currentTimeMillis()<4000){
						try {
							Thread.sleep(4000-(startUpdataTime-java.lang.System.currentTimeMillis()));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					handler.sendMessage(message);
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
