package com.example.awesomeapp.fragments_mainactivity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by minetea on 2017/10/16.
 */

public class CustomViewPager extends ViewPager
	{

	private boolean isCanScroll = false;
	
	public CustomViewPager(Context context) {
	super(context);
	}
	
	public CustomViewPager(Context context, AttributeSet attrs) {
	super(context, attrs);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
	return isCanScroll && super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
	return isCanScroll && super.onTouchEvent(ev);
		
	}
}
