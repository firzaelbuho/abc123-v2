package com.proximastudio.abc123.unity

import android.util.Log
import com.unity3d.services.banners.BannerErrorInfo
import com.unity3d.services.banners.BannerView



    class UnityBannerListener : BannerView.IListener {
        override fun onBannerLoaded(bannerAdView: BannerView) {
            // Called when the banner is loaded.
        }

        override fun onBannerFailedToLoad(
            bannerAdView: BannerView,
            errorInfo: BannerErrorInfo
        ) {
            Log.d("SupportTest", "Banner Error$")
            // Note that the BannerErrorInfo object can indicate a no fill (see API documentation).
        }

        override fun onBannerClick(bannerAdView: BannerView) {
            // Called when a banner is clicked.
        }

        override fun onBannerLeftApplication(bannerAdView: BannerView) {
            // Called when the banner links out of the application.
        }
    }

