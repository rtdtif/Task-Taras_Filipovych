package com.example.task_taras_filipovych

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class BigPictureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_picture)
        val WebView_photo = findViewById<WebView>(R.id.webview)
        val clickURL = intent.getStringExtra(PhotoAdapter.ViewHolder.Photo_Url )
        WebView_photo.settings.javaScriptEnabled = true
        WebView_photo.settings.loadWithOverviewMode = true
        WebView_photo.settings.useWideViewPort = true
        WebView_photo.loadUrl(clickURL)
    }
}
