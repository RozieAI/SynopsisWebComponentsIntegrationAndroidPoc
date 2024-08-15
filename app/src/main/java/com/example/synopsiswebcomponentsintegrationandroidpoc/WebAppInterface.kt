package com.example.synopsiswebcomponentsintegrationandroidpoc

import android.content.Context
import android.content.Intent
import android.webkit.JavascriptInterface

class WebAppInterface(private val requireContext: Context) {
    @JavascriptInterface
    fun onButtonClicked(redirectUrl: String?) {
        // Handle the redirectUrl here
        // For example, start a new activity with the redirectUrl
        if (redirectUrl != null) {
            // Start the full-screen activity
            val intent = Intent(requireContext, FullscreenWebViewActivity::class.java)
            intent.putExtra("redirectUrl", redirectUrl)
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(redirectUrl))
            requireContext.startActivity(intent)
        } else {
            // Handle the case where redirectUrl is null
            print("No url")
        }

    }
}
