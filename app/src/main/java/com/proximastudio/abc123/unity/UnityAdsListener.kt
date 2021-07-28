package com.proximastudio.abc123.unity

import android.util.Log
import com.unity3d.ads.IUnityAdsListener
import com.unity3d.ads.UnityAds

class UnityAdsListener : IUnityAdsListener {
    override fun onUnityAdsReady(adUnitId: String) {
        // Implement functionality for an ad being ready to show.
        Log.d("SDK Unity Ads Ready", "Yess")
    }

    override fun onUnityAdsStart(adUnitId: String) {
        // Implement functionality for a user starting to watch an ad.
    }

    override fun onUnityAdsFinish(adUnitId: String, finishState: UnityAds.FinishState) {
        // Implement functionality for a user finishing an ad.
    }

    override fun onUnityAdsError(error: UnityAds.UnityAdsError, message: String) {
        // Implement functionality for a Unity Ads service error occurring.
    }
}