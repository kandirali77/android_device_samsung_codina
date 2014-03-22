package com.cyanogenmod.settings.device;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

public class ContainerActivity extends Activity {

	FrameLayout frameLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.container);
		frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
		
		Fragment fragment = new Fragment();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();

		switch (getIntent().getExtras().getInt(MainActivity.SELECTION)) {
		case 0:
			// General
			fragment = new GeneralFragmentActivity();
			break;
		case 1:
			// USB
			fragment = new USBFragmentActivity();
			break;
		case 2:
			// Audio
			fragment = new AudioFragmentActivity();
			break;
		case 3:
			// Advanced
			fragment = new AdvancedFragmentActivity();
			break;

		default:
			break;
		}
		
		transaction.replace(R.id.frameLayout, fragment);
		transaction.commit();

		super.onCreate(savedInstanceState);
	}

}
