package com.example.beatrice.globonews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Objects;

public class NewsWebViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_webview, container, false);
        configure(view);
        openAbout(view);

        return view;
    }

    private void openAbout(View view) {

        WebView webView = view.findViewById(R.id.about_webview);
        final ContentLoadingProgressBar progressBar = view.findViewById(R.id.about_progressbar);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                progressBar.show();
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                System.out.println("on finish");
                progressBar.hide();
            }
        });
        webView.loadUrl("http://google.com");
    }

    private void configure(View view) {

        Toolbar toolbar = view.findViewById(R.id.about_toolbar);

        toolbar.setTitle(R.string.app_name);

        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();

        Objects.requireNonNull(appCompatActivity).setSupportActionBar(toolbar);

        ActionBar actionBar = appCompatActivity.getSupportActionBar();

        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setDisplayShowHomeEnabled(true);
        }

        toolbar.setNavigationOnClickListener(view1 -> backNavigation());
    }

    private void backNavigation() {

        if (getFragmentManager() != null) {

            getFragmentManager().popBackStack();
        }
    }
}