package com.example.awesomeapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.WindowManager;

import com.example.awesomeapp.fragments_subjects.FullScreenVideoView;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity
	{
	
	private JZVideoPlayerStandard videoplayer;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		
		//采用新版本的隐藏标题栏方法
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		//透明状态栏
		initState();
		
		}
	
	@Override
	protected void onStart()
		{
		
		super.onStart();
		
		//播放网络视频功能
		JZVideoPlayerStandard videoplayer = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
		
		//获取从上一个 activity 中传入的 url
		this.intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		String url = bundle.getString("url");
		
		videoplayer.setUp(url,JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, " ");
		
		}
	@Override
	public void onBackPressed() {
	if (JZVideoPlayer.backPress()) {
	return;
	}
	super.onBackPressed();
	}
	@Override
	protected void onPause() {
	super.onPause();
	JZVideoPlayer.releaseAllVideos();
	}
	
	//透明状态栏
	private void initState() {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
	}
	}
	}

	
