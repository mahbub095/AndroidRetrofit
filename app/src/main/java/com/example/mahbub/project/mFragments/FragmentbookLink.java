package com.example.mahbub.project.mFragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.mahbub.project.R;


public class FragmentbookLink extends Fragment {
    WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragmentbook_link, container, false);
        this.wv = (WebView) view.findViewById(R.id.webview);
        this.wv.getSettings().setJavaScriptEnabled(true);
        this.wv.setFocusable(true);
        this.wv.setFocusableInTouchMode(true);
        this.wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        // this.wv.getSettings().setCacheMode(2);
        if (Build.VERSION.SDK_INT >= 19) {
            this.wv.setLayerType(2, null);
        } else {
            this.wv.setLayerType(1, null);
        }
        this.wv.getSettings().setDomStorageEnabled(true);
        this.wv.getSettings().setDatabaseEnabled(true);
        this.wv.getSettings().setAppCacheEnabled(true);
        //   this.wv.setScrollBarStyle(0);
        this.wv.loadUrl("https://drive.google.com/drive/folders/1cbIJpwuQ-c_lFR0nVSi1P5sxGf9nNl8R");
        this.wv.setWebViewClient(new WebViewClient());
        return view;
    }
    @Override
    public String toString() {
        String title="Download";
        return title;
    }


}
