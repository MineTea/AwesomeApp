package com.example.awesomeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.session.MediaController;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.example.awesomeapp.fragments_mainactivity.MyAdapt;
import com.example.awesomeapp.fragments_subjects.Fragment_Biology;
import com.example.awesomeapp.fragments_subjects.Fragment_Chemistry;
import com.example.awesomeapp.fragments_subjects.Fragment_Chinese;
import com.example.awesomeapp.fragments_subjects.Fragment_English;
import com.example.awesomeapp.fragments_subjects.Fragment_Geography;
import com.example.awesomeapp.fragments_subjects.Fragment_History;
import com.example.awesomeapp.fragments_subjects.Fragment_Maths;
import com.example.awesomeapp.fragments_subjects.Fragment_Physics;
import com.example.awesomeapp.fragments_subjects.Fragment_Politics;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SubjectActivity extends AppCompatActivity
	{
	
	//获取各种控件
	public static ViewPager viewpager;
	private SmartTabLayout smarttab;
	private MediaController mediaController;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject);
		
		//采用新版本的隐藏标题栏方法
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
		//隐藏状态栏
		initState();
		
		//Fragment 和 viewpager 相关设置
		List<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(new Fragment_Chinese());
		fragments.add(new Fragment_Maths());
		fragments.add(new Fragment_English());
		fragments.add(new Fragment_Physics());
		fragments.add(new Fragment_Chemistry());
		fragments.add(new Fragment_Biology());
		fragments.add(new Fragment_Politics());
		fragments.add(new Fragment_History());
		fragments.add(new Fragment_Geography());
		
		MyAdapt myAdapt = new MyAdapt(getSupportFragmentManager(),fragments);
		this.viewpager = (ViewPager) findViewById(R.id.viewpager);
		viewpager.setAdapter(myAdapt);
		//添加 smarttablayout
		this.smarttab = (SmartTabLayout) findViewById(R.id.smarttab);
		smarttab.setViewPager(viewpager);
		//从 MainActivity 中获取 intent ,设置页面
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		int page = bundle.getInt("page");
		viewpager.setCurrentItem(page);
		
		}
	
	//透明状态栏
	private void initState()
			{
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
			{
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			}
		}
	}
