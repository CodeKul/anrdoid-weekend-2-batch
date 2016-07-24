package com.melayer.intentandintentfilters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent responsibleIntent =
                getIntent();

        final WebView webView =
                (WebView) findViewById(R.id.webView);
        webView.loadUrl(responsibleIntent.getData().toString());
    }
}
