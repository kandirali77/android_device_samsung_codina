OmniROM 4.4
=============================
Device Tree for Samsung Galaxy Ace 2
(GT-I8160)

How to build:
=============

- Make a workspace

  $ mkdir -p ~/omni/system
  $ cd ~/omni/system
  
- Do repo init & sync

  repo init https://github.com/TeamCanjica/android.git -b omni-4.4
  
  repo sync -j32

- Setup vendor
  
  . build/envsetup.sh

- Pull all not merged fixes from gerrit:

			cd art
    			git fetch https://github.com/TeamCanjica/omni_art android-4.4
    			git cherry-pick e5d00edb9d6cff7845b72e32ed8e048e7234c688
    			cd ..
			cd frameworks/av
    			git fetch https://github.com/TeamCanjica/omni_frameworks_av android-4.4
    			git cherry-pick 3e8e2b16811e8c060d3339869b4f85b4842c26a7
    			cd ..
			cd native
    			git fetch https://github.com/TeamCanjica/omni_frameworks_native android-4.4
    			git cherry-pick 90db937c9b944c87a386c2b5b713dae811cf69cc
    			git fetch http://review.cyanogenmod.org/CyanogenMod/android_frameworks_native refs/changes/11/59311/1
  			git cherry-pick FETCH_HEAD
  			cd ..
			cd base
			git fetch https://github.com/TeamCanjica/android_frameworks_base cm-11.0
  			git cherry-pick bb9d91d07fdc20c2443c9668e2f20e392b25bac4
  			cd ..
  			cd opt/telephony
    			git fetch https://github.com/TeamCanjica/omni_frameworks_opt_telephony android-4.4
    			git cherry-pick 5e09e67658d95db425d3684e65fbcf73a3705a5b
    			cd ../../..
			cd system/core
			git fetch https://github.com/TeamCanjica/android_system_core cm-11.0
			git cherry-pick 7bd81ee140c09066ede2ffab47da1a1c4e54e021
			git cherry-pick b6cb91b1f70c969bb0f818a24111c0ca055be590
			cd ..
			cd vold
			git fetch http://review.cyanogenmod.org/CyanogenMod/android_system_vold refs/changes/15/56515/2
			git cherry-pick FETCH_HEAD
			cd ../..
			cd hardware/libhardware_legacy
			git fetch https://github.com/TeamCanjica/omni_hardware_libhardware_legacy android-4.4
    			git cherry-pick 2e71ea08a201040727f1e82768e9e50e1cf44fe9
			cd ../..
			cd packages/services/Telephony
    			git fetch https://github.com/TeamCanjica/omni_packages_services_Telephony android-4.4
    			git cherry-pick 167b42ab759bf5c9612cf81d8e2a9315534dd3c8
    			cd ../../..
		
- Build Omni
  
  brunch codina


- Thanks : Omni, dh-harald, Sakura Droid, jereksel, diego-ch, frapeti, OliverG96, ekim.tecul
