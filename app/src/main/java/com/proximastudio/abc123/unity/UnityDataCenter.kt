package com.proximastudio.abc123.unity

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.unity3d.ads.UnityAds
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize

object UnityDataCenter {

    val testMode = false
    val adBannerId = "Banner_Android"
    val unityGameId = "4235509"

    fun initializeAds(context : Context){

        val myAdsListener = UnityAdsListener()
        // Add the listener to the SDK:
        UnityAds.addListener(myAdsListener)
        // Initialize the SDK:
        UnityAds.initialize(context, unityGameId, testMode)
    }

    fun showBanner(activity: Activity, layout: LinearLayout){

        val bannerListener = UnityBannerListener()

        val banner = BannerView(activity, adBannerId, UnityBannerSize(320, 50))
        banner.listener = bannerListener
        banner.load()
        layout.addView(banner)


    }



}