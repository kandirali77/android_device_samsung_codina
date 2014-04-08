package com.teamcanjica.settings.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceChangeListener;
import android.util.AttributeSet;

public class GPUClockSpeed extends ListPreference implements
OnPreferenceChangeListener {

	public GPUClockSpeed(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOnPreferenceChangeListener(this);
	}
	
	private static final String FILE = "/sys/kernel/mali/mali_gpu_clock";
	
	public static boolean isSupported() {
		return Utils.fileExists(FILE);
	}

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		Utils.writeValue(FILE, (String) newValue);
		return true;
	}
	
	public static void restore(Context context) {
		if (!isSupported()) {
			return;
		}

		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		Utils.writeValue(FILE, sharedPrefs.getString(
				DeviceSettings.KEY_SET_GPU_CLOCK, "499200"));
	}

}
