package com.example.awesomeapp;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.StaticLayout;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.awesomeapp.fragments_mainactivity.FragmentDownloads_MainActivity;
import com.example.awesomeapp.fragments_mainactivity.FragmentHome_MainActivity;
import com.example.awesomeapp.fragments_mainactivity.FragmentNotification_MainActivity;
import com.example.awesomeapp.fragments_mainactivity.FragmentPerson_MainActivity;
import com.example.awesomeapp.fragments_mainactivity.MyAdapt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
	{
	
	//声明各种控件
	private BottomNavigationView bottomNavigation_MainActivity;
	private ViewPager viewPager_MainActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//获取底部导航栏，绑定被选择的事件
		BottomNavigationView bottomNavigation = (BottomNavigationView)findViewById(R.id.bottomNavigation);
		bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		
		//获取 ViewPager
		final ViewPager viewPager_MainActivity =  (ViewPager)findViewById(R.id.viewPager_MainActivity);
		this.viewPager_MainActivity = viewPager_MainActivity;
		//创建 Fragments List , 并加入到 Adapter
		List<Fragment> myFragments_MainActivity = new ArrayList<Fragment>();
		myFragments_MainActivity.add(new FragmentHome_MainActivity());
		myFragments_MainActivity.add(new FragmentDownloads_MainActivity());
		myFragments_MainActivity.add(new FragmentNotification_MainActivity());
		myFragments_MainActivity.add(new FragmentPerson_MainActivity());
		MyAdapt myAdapt_MainActivity = new MyAdapt(getSupportFragmentManager(),myFragments_MainActivity);
		//设置 ViewPager 的 Adapter
		viewPager_MainActivity.setAdapter(myAdapt_MainActivity);
			
		}
	
	//底部导航栏的点击事件监听
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener()
		{
		
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item)
			{
			switch (item.getItemId())
				{
				case R.id.navigation_home:
					viewPager_MainActivity.setCurrentItem(0);
					return true;
				case R.id.navigation_downloads:
					viewPager_MainActivity.setCurrentItem(1);
					return true;
				case R.id.navigation_notifications:
					viewPager_MainActivity.setCurrentItem(2);
					return true;
				case R.id.navigation_person:
					viewPager_MainActivity.setCurrentItem(3);
					return true;
				}
			return false;
			}
			
		};
	
	}
