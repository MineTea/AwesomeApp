package com.example.awesomeapp.fragments_mainactivity;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.awesomeapp.LoginActivity;
import com.example.awesomeapp.R;

/**
 * Created by minetea on 2017/10/4.
 */

public class FragmentCourses_MainActivity extends Fragment
	{
	private WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
		View view = inflater.inflate(R.layout.fragment_downloads,container,false);

		return view;
		}
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
		{
		super.onActivityCreated(savedInstanceState);
		//决定用 webview 来加载 html。。。
		this.webView = (WebView)getActivity().findViewById(R.id.webView);
		webView.setWebViewClient(new WebViewClient()
			{
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
			}
			});
		//支持 js
		webView.getSettings().setJavaScriptEnabled(true);
		//缓存：默认模式
		webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		webView.loadUrl("http://www.imooc.com/");
		}
		
	}

