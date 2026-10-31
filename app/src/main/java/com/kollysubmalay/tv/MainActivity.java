package com.kollysubmalay.tv;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private WebView webView;

    private final String website =
        "https://tamilsubmalay.com/wp-login.php?redirect_to=https%3A%2F%2Ftamilsubmalay.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        showHome();
    }

    private void showHome() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(50, 40, 50, 40);
        layout.setBackgroundColor(Color.rgb(8, 10, 16));

        TextView title = new TextView(this);
        title.setText("KOLLYSUBMALAY");
        title.setTextColor(Color.WHITE);
        title.setTextSize(34);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView subtitle = new TextView(this);
        subtitle.setText("YOUR TAMIL ENTERTAINMENT");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(14);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 15, 0, 35);

        Button login = new Button(this);
        login.setText("BUKA KOLLYSUBMALAY");
        login.setTextColor(Color.WHITE);
        login.setTextSize(16);
        login.setAllCaps(false);

        GradientDrawable shape = new GradientDrawable();
        shape.setColor(Color.rgb(35, 105, 220));
        shape.setCornerRadius(18);
        login.setBackground(shape);

        login.setOnClickListener(v -> openWebsite());

        layout.addView(title);
        layout.addView(subtitle);
        layout.addView(login);

        setContentView(layout);
        login.requestFocus();
    }

    private void openWebsite() {
        webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);

        CookieManager.getInstance().setAcceptCookie(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        setContentView(webView);
        webView.loadUrl(website);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            showHome();
        }
    }
}
