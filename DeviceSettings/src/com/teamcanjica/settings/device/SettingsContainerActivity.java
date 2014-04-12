package com.teamcanjica.settings.device;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.teamcanjica.settings.device.fragments.SettingsFragmentActivity;

public class SettingsContainerActivity extends Activity {

	FrameLayout frameLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.container);
		frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
		
		getFragmentManager().beginTransaction().
			replace(R.id.frameLayout, new SettingsFragmentActivity()).commit();
		
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.device_settings, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_about:
	        	startActivity(new Intent(this, AboutActivity.class));
	            return true;
	        case R.id.action_settings:
	        	getFragmentManager().beginTransaction().
					replace(R.id.frameLayout, new SettingsFragmentActivity()).commit();
	        	return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
