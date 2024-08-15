package com.example.synopsiswebcomponentsintegrationandroidpoc

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class FullscreenWebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen_web_view)

        val webView = findViewById<WebView>(R.id.fullscreenWebView)
        webView.settings.javaScriptEnabled = true

        val redirectUrl = intent.getStringExtra("redirectUrl")
        if (redirectUrl != null) {
            webView.loadUrl(redirectUrl)
        }

        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}