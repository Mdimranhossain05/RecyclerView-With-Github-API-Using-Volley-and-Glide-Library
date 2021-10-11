package com.example.volleylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webviewID);
        Bundle bundle = getIntent().getExtras();

        String url = bundle.getString("url");
        webView.setWebViewClient(new WebViewClient());

        webView = findViewById(R.id.webviewID);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webView.loadUrl(url);

    }

    @Override
    public void onBackPressed() {

        if (webView.canGoBack()){
            webView.goBack();
        }
        else {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }

        super.onBackPressed();
    }
}