package com.wishadesign.app.skochvoting.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wishadesign.app.skochvoting.R;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        CookieManager.getInstance().setAcceptCookie(true);
        WebView webContainer = (WebView) findViewById(R.id.webview_container);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webContainer, true);
        }
        webContainer.getSettings().setJavaScriptEnabled(true);
        WebSettings settings = webContainer.getSettings();
        settings.setDomStorageEnabled(true);
        webContainer.getSettings().setAppCacheEnabled(true);
        webContainer.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webContainer.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                CookieSyncManager.getInstance().sync();
            }
        });
        webContainer.loadUrl("http://skochvoting.tk/user/signin/signin.html");
        CookieManager.getInstance().setAcceptCookie(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webContainer, true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().stopSync();
    }
    @Override
    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().sync();
    }

}
