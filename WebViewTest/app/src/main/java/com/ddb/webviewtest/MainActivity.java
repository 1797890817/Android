package com.ddb.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String url = "";
    EditText inputUrl = null;
    WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUrl = (EditText) findViewById(R.id.input_site);
        webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        Button openUrl = (Button) findViewById(R.id.open_url);
        openUrl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        url = inputUrl.getText().toString() + "";
        if (!"".equals(url)) {
            if (!url.contains("http://")) {
                url = "http://" + url;
            }
            webView.loadUrl(url);
        } else {
            Toast.makeText(MainActivity.this, "请输入网址！", Toast.LENGTH_SHORT).show();
        }
    }
}
