package com.example.awesomeapp;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.StaticLayout;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
	{
	
	//声明各种控件
	private TextView mTextMessage;
	private BottomNavigationView bottomNavigation;
	
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
					Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
					return true;
				case R.id.navigation_downloads:
					Toast.makeText(MainActivity.this,"downloads",Toast.LENGTH_SHORT).show();
					return true;
				case R.id.navigation_notifications:
					Toast.makeText(MainActivity.this,"notification",Toast.LENGTH_SHORT).show();
					return true;
				case R.id.navigation_person:
					Toast.makeText(MainActivity.this,"person",Toast.LENGTH_SHORT).show();
					return true;
				}
			return false;
			}
			
		};
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//获取底部导航栏，绑定被选择的事件
		BottomNavigationView bottomNavigation = (BottomNavigationView)findViewById(R.id.bottomNavigation);
		bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		
		}
		
	}
