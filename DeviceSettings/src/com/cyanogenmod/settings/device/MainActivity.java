package com.cyanogenmod.settings.device;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener{
	
	public static final String SELECTION = "selection";
	ListView settingsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_device_settings);
		settingsList = (ListView) findViewById(R.id.settingsList);
		settingsList.setOnItemClickListener(this);
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int index, long arg3) {
		Intent intent = new Intent(this, ContainerActivity.class);
		intent.putExtra(SELECTION, index);			
		startActivity(intent);		
	}

}
