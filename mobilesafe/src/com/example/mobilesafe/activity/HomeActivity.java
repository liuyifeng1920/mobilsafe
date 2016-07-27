package com.example.mobilesafe.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilesafe.R;
import com.example.mobilesafe.utils.ContansValue;
import com.example.mobilesafe.utils.SpUtil;
import com.example.mobilesafe.utils.ToastUtil;

/**
 * @author Administrator ��ҳ
 */
public class HomeActivity extends Activity {
	protected static final String HomeActivity = "HomeActivity";
	private GridView gridView;
	private String[] names;
	private int[] imageRs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		initUI();

		initData();
	}

	private void initData() {
		names = new String[] { "�ֻ�����", "ͨ����ʿ", "�������", "���̹���", "����ͳ��", "�ֻ�ɱ��",
				"��������", "�߼�����", "��������" };
		imageRs = new int[] { R.drawable.home_apps,
				R.drawable.home_callmsgsafe, R.drawable.home_netmanager,
				R.drawable.home_safe, R.drawable.home_settings,
				R.drawable.home_sysoptimize, R.drawable.home_taskmanager,
				R.drawable.home_tools, R.drawable.home_trojan };

		gridView.setAdapter(new MyAdapter());
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					String psd = SpUtil.getString(getApplicationContext(),
							ContansValue.MOBILE_SETTING_PSD, "");
					if (TextUtils.isEmpty(psd)) {
						alertSettingPsdDailag();
					} else {
						alertCheckPsdDailag();
					}
					break;
				case 1:

					break;
				case 2:

					break;
				case 8:
					Intent intent = new Intent(getApplicationContext(),
							SettingActivity.class);
					startActivity(intent);
					Log.i(HomeActivity, "������������");
					break;
				default:
					break;
				}
			}

		});
	}

	/*
	 * ̽�����������˫��Ի���
	 */
	protected void alertSettingPsdDailag() {
		Builder builder = new AlertDialog.Builder(this);
		final AlertDialog alertDialog = builder.create();
		final View view = View.inflate(this, R.layout.activity_set_pd,null);
		alertDialog.setView(view);
		alertDialog.show();
		
		//��ȷ����ȡ����ť��ʱ��
		Button bt_submit=	(Button)view.findViewById(R.id.bt_submit);
		Button bt_cancel=	(Button)view.findViewById(R.id.bt_cancel);
	
	bt_submit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//��ȡ������������ݽ�����֤�Ա�
			EditText et_set_pd_et =  (EditText)view.findViewById(R.id.et_set_pd);
			String et_set_pd =et_set_pd_et.getText().toString();
			EditText et_set_pd2_et =  (EditText)view.findViewById(R.id.et_set_pd2);
			String et_set_pd2 =et_set_pd2_et.getText().toString();
			
			if(!TextUtils.isEmpty(et_set_pd)||!TextUtils.isEmpty(et_set_pd2)){
				if(et_set_pd.equals(et_set_pd2)){
					//��������
					SpUtil.addString(getApplicationContext(), ContansValue.MOBILE_SETTING_PSD, et_set_pd);
					ToastUtil.show(getApplicationContext(), "׼�������µ�Activity");
					
				}else{
					ToastUtil.show(getApplicationContext(), "�������벻һ��");
				}
			}else{
				Toast.makeText(getApplicationContext(), "����������", 1).show();
			}
			
		}
	});
	
	
	bt_cancel.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			alertDialog.dismiss();
		}
	});
	}

	/**
	 * ������֤����ĶԻ���
	 */
	protected void alertCheckPsdDailag() {

		Builder builder = new AlertDialog.Builder(this);
		final AlertDialog alertDialog = builder.create();
		final View view = View.inflate(this, R.layout.activity_confirm_pd,null);
		alertDialog.setView(view);
		alertDialog.show();
		
		//��ȷ����ȡ����ť��ʱ��
		Button bt_submit=	(Button)view.findViewById(R.id.bt_submit);
		Button bt_cancel=	(Button)view.findViewById(R.id.bt_cancel);
	
	bt_submit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//��ȡ������������ݽ�����֤�Ա�
			EditText et_set_pd_et =  (EditText)view.findViewById(R.id.et_set_pd);
			String et_set_pd =et_set_pd_et.getText().toString();
			
			
			if(!TextUtils.isEmpty(et_set_pd)){
				String psd = SpUtil.getString(getApplicationContext(),ContansValue.MOBILE_SETTING_PSD , "");
				if(et_set_pd.equals(psd)){
					enterFangdao();
					ToastUtil.show(getApplicationContext(), "׼�������µ�Activity");
					alertDialog.dismiss();
					
				}else{
					ToastUtil.show(getApplicationContext(), "�����������");
				}
			}else{
				Toast.makeText(getApplicationContext(), "����������", 1).show();
			}
			
		}
	});
	
	
	bt_cancel.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			alertDialog.dismiss();
		}
	});
	

	}
	/**
	 * ��ת���뵽����ҳ��
	 */
	protected void enterFangdao() {
		Intent intent =new Intent(getApplicationContext(),FangdaoActivity.class);
		startActivity(intent);
	}

	private void initUI() {
		gridView = (GridView) findViewById(R.id.gv_home);

	}

	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return names.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return names[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(getApplicationContext(),
					R.layout.grid_view_home, null);

			ImageView imageView = (ImageView) view.findViewById(R.id.gv_icon);

			TextView textView = (TextView) view.findViewById(R.id.tx_title);
			imageView.setBackgroundResource(imageRs[position]);
			textView.setText(names[position]);
			return view;
		}

	}
}
