package com.wishadesign.app.skochvoting.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.wishadesign.app.skochvoting.R;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webContainer = (WebView) findViewById(R.id.webview_container);
        webContainer.loadUrl("http://skochvoting.tk/voting/signin/signin.html");

    }

}
