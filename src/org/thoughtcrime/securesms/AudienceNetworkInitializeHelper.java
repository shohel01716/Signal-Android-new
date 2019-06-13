package org.thoughtcrime.securesms;

import android.content.Context;
import android.util.Log;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;

import static org.thoughtcrime.securesms.BuildConfig.DEBUG;

public class AudienceNetworkInitializeHelper
        implements AudienceNetworkAds.InitListener {

    /**
     * It's recommended to call this method from Application.onCreate().
     * Otherwise you can call it from all Activity.onCreate()
     * methods for Activities that contain ads.
     *
     * @param context Application or Activity.
     */
    static void initialize(Context context) {
        AudienceNetworkAds
                .buildInitSettings(context)
                .withInitListener(new AudienceNetworkInitializeHelper())
                .initialize();
    }

    @Override
    public void onInitialized(AudienceNetworkAds.InitResult result) {
        Log.d(AudienceNetworkAds.TAG, result.getMessage());
    }
}