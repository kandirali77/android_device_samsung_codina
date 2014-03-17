/*
 * Copyright (C) 2012 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cyanogenmod.settings.device;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;

public class AudioFragmentActivity extends PreferenceFragment {

	private static final String TAG = "GalaxyAce2_Settings_Audio";
	
	public static final String FILE_ANAGAIN3 = "/sys/kernel/abb-codec/anagain3";
	
	public static final String FILE_HSLDIGGAIN = "/sys/kernel/abb-codec/hsldiggain";
	
	public static final String FILE_HSRDIGGAIN = "/sys/kernel/abb-codec/hsrdiggain";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.audio_preferences);

		PreferenceScreen prefSet = getPreferenceScreen();
	}
	
	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {

		String boxValue;
		String key = preference.getKey();

		Log.w(TAG, "key: " + key);

		if (key.equals(DeviceSettings.KEY_ENABLE_ANAGAIN3)) {
			boxValue = (((CheckBoxPreference) preference).isChecked() ? "on"
					: "off");
			Utils.writeValue(FILE_ANAGAIN3, boxValue);
		}

		if (key.equals(DeviceSettings.KEY_ENABLE_HSLDIGGAIN)) {
			boxValue = (((CheckBoxPreference) preference).isChecked() ? "on"
					: "off");
			Utils.writeValue(FILE_HSLDIGGAIN, boxValue);
		}
		
		if (key.equals(DeviceSettings.KEY_ENABLE_HSRDIGGAIN)) {
			boxValue = (((CheckBoxPreference) preference).isChecked() ? "on"
					: "off");
			Utils.writeValue(FILE_HSRDIGGAIN, boxValue);
		}

		return true;
	}
	
	public static void restore(Context context) {
		SharedPreferences sharedPrefs = PreferenceManager
				.getDefaultSharedPreferences(context);
		
		String anagain3value = sharedPrefs.getBoolean(
				DeviceSettings.KEY_ENABLE_ANAGAIN3, false) ? "on" : "off";
		Utils.writeValue(FILE_ANAGAIN3, anagain3value);
		
		String hsldiggainvalue = sharedPrefs.getBoolean(
				DeviceSettings.KEY_ENABLE_HSLDIGGAIN, false) ? "on" : "off";
		Utils.writeValue(FILE_HSLDIGGAIN, hsldiggainvalue);
		
		String hsrdiggainvalue = sharedPrefs.getBoolean(
				DeviceSettings.KEY_ENABLE_HSRDIGGAIN, false) ? "on" : "off";
		Utils.writeValue(FILE_HSRDIGGAIN, hsrdiggainvalue);
	}

}
