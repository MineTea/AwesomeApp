package com.example.awesomeapp;

import android.annotation.SuppressLint;
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
import com.example.awesomeapp.fragments_subjects.Fragment_Chinese;
import com.example.awesomeapp.fragments_subjects.Fragment_Maths;
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
	private ViewPager viewpager;
	private SmartTabLayout smarttab;
	
	
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
		MyAdapt myAdapt = new MyAdapt(getSupportFragmentManager(),fragments);
		ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
		this.viewpager = viewpager;
		viewpager.setAdapter(myAdapt);
		//添加 smarttablayout
		SmartTabLayout  smarttab = (SmartTabLayout) findViewById(R.id.smarttab);
		this.smarttab = smarttab;
		smarttab.setViewPager(viewpager);
			
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
